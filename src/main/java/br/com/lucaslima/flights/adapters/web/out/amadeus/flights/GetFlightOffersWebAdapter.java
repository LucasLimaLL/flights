package br.com.lucaslima.flights.adapters.web.out.amadeus.flights;

import br.com.lucaslima.flights.adapters.web.out.amadeus.flights.feign.GetFlightOffersClient;
import br.com.lucaslima.flights.application.domain.Arrival;
import br.com.lucaslima.flights.application.domain.Departure;
import br.com.lucaslima.flights.application.domain.FlightOffer;
import br.com.lucaslima.flights.application.domain.Itinerary;
import br.com.lucaslima.flights.application.domain.Price;
import br.com.lucaslima.flights.application.ports.out.GetFlightOffersPort;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

@Slf4j
@Component
public class GetFlightOffersWebAdapter implements GetFlightOffersPort {

    private static final ZoneId ZONE_ID = ZoneId.of("UTC");
    private final Random random = new Random();
    private final GetFlightOffersClient getFlightOffersClient;
    private final Cache<String, List<FlightOffer>> cache;

    public GetFlightOffersWebAdapter(GetFlightOffersClient getFlightOffersClient) {
        this.getFlightOffersClient = getFlightOffersClient;
        this.cache = Caffeine
                .newBuilder()
                .expireAfterWrite(Duration.ofMinutes(60))
                .build();
    }

    @Override
    @SneakyThrows
    public List<FlightOffer> search(String iataCodeDeparture, String iataCodeArrival, ZonedDateTime departureDate, ZonedDateTime returnDate, int adults, boolean nonStop, String currencyCode) {

        try {
            var departure = departureDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            var cacheKey = String.join("", iataCodeDeparture, iataCodeArrival, departure);

            if (cache.getIfPresent(cacheKey) != null) {
                return cache.getIfPresent(cacheKey);
            }

            var flightOffers = new ArrayList<FlightOffer>();
            var response = getFlightOffersClient.getFlightOffers(
                    iataCodeDeparture,
                    iataCodeArrival,
                    departure,
                    adults,
                    nonStop,
                    currencyCode
            );

            response.getBody().data().forEach(data -> {

                data
                        .itineraries()
                        .getFirst()
                        .segments()
                        .sort(Comparator.comparing(segment -> segment.departure().at()));

                var departureResponse = data.itineraries().getFirst().segments().getFirst().departure();
                var arrivalResponse = data.itineraries().getFirst().segments().getLast().arrival();
                var firstDeparture = new Departure(departureResponse.iataCode(), departureResponse.at().atZone(ZONE_ID));
                var lastArrival = new Arrival(arrivalResponse.iataCode(), arrivalResponse.at().atZone(ZONE_ID));

                List<Itinerary> itineraries = data
                        .itineraries()
                        .getFirst()
                        .segments()
                        .stream().map(segment -> {
                            Departure departureSegment = new Departure(segment.departure().iataCode(), segment.departure().at().atZone(ZONE_ID));
                            Arrival arrivalSegment = new Arrival(segment.arrival().iataCode(), segment.arrival().at().atZone(ZONE_ID));
                            return new Itinerary(response.getBody().dictionaries().carriers().get(segment.carrierCode()).toString(), departureSegment, arrivalSegment);
                        }).toList();
                Price price = new Price(data.price().currency(), data.price().base(), data.price().total());

                flightOffers.add(new FlightOffer(itineraries, price, firstDeparture, lastArrival));
            });

            cache.put(cacheKey, flightOffers);

            return flightOffers;
        } catch (Exception e) {
            log.error("Error to get flight offers", e);
            throw e;
        }
    }
}
