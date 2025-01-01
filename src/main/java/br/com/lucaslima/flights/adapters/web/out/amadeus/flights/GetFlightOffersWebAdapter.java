package br.com.lucaslima.flights.adapters.web.out.amadeus.flights;

import br.com.lucaslima.flights.adapters.web.out.amadeus.flights.feign.GetFlightOffersClient;
import br.com.lucaslima.flights.application.domain.Arrival;
import br.com.lucaslima.flights.application.domain.Departure;
import br.com.lucaslima.flights.application.domain.FlightOffer;
import br.com.lucaslima.flights.application.domain.Itinerary;
import br.com.lucaslima.flights.application.domain.Price;
import br.com.lucaslima.flights.application.ports.out.GetFlightOffersPort;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Random;

@Component
public class GetFlightOffersWebAdapter implements GetFlightOffersPort {

    private final Random random = new Random();
    private final GetFlightOffersClient getFlightOffersClient;

    public GetFlightOffersWebAdapter(GetFlightOffersClient getFlightOffersClient) {
        this.getFlightOffersClient = getFlightOffersClient;
    }

    @Override
    @SneakyThrows
    public List<FlightOffer> search(String iataCodeDeparture, String iataCodeArrival, ZonedDateTime departureDate, ZonedDateTime returnDate, int adults, boolean nonStop, String currencyCode) {

        try {
            var response = getFlightOffersClient.getFlightOffers(
                    iataCodeDeparture,
                    iataCodeArrival,
                    departureDate.toString(),
                    adults,
                    nonStop,
                    currencyCode
            );
        } catch (Exception e) {
            e.printStackTrace();
        }


        Departure firstDeparture = new Departure(iataCodeDeparture, departureDate);
        Arrival lastArrival = new Arrival(iataCodeArrival, returnDate);
        List<Itinerary> itineraries = List.of(new Itinerary(firstDeparture, lastArrival));
        Price price = new Price(currencyCode, new BigDecimal(random.nextDouble(2000)), new BigDecimal(random.nextDouble(2000)));

        Thread.sleep(1000);

        return List.of(
                new FlightOffer(itineraries, price, firstDeparture, lastArrival)
        );

    }
}
