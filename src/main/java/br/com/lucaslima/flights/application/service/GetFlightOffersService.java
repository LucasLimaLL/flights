package br.com.lucaslima.flights.application.service;

import br.com.lucaslima.flights.application.domain.FlightOffer;
import br.com.lucaslima.flights.application.ports.in.GetFlightOffersUseCase;
import br.com.lucaslima.flights.application.ports.out.GetFlightOffersPort;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class GetFlightOffersService implements GetFlightOffersUseCase {

    private final GetFlightOffersPort getFlightOffersPort;
    private final String currencyCode;
    private final ExecutorService executorService;

    public GetFlightOffersService(GetFlightOffersPort getFlightOffersPort) {
        this.getFlightOffersPort = getFlightOffersPort;
        this.currencyCode = "BRL";
        this.executorService = Executors.newVirtualThreadPerTaskExecutor();
    }

    @Override
    public List<FlightOffer> search(String iataCodeDeparture,
                                    String iataCodeArrival,
                                    boolean nonStop,
                                    int daysToDeparture,
                                    ZonedDateTime desiredDate,
                                    int precision) {

        var flightsOffers = new ArrayList<FlightOffer>();
        var surroundingDepartureDays = getSurroundingDays(desiredDate, precision);
        List<Future<?>> futures = new ArrayList<>();

        for (ZonedDateTime departureDate : surroundingDepartureDays) {
            var surroundingArrivalDays = getSurroundingDays(departureDate.plusDays(daysToDeparture), precision);
            for (ZonedDateTime arrivalDate : surroundingArrivalDays) {
                futures.add(executorService.submit(() -> getFlightOffers(iataCodeDeparture, iataCodeArrival, nonStop, departureDate, arrivalDate, flightsOffers)));
            }
        }

        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return flightsOffers;
    }

    @Override
    public List<FlightOffer> search(String iataCodeDeparture,
                                    String iataCodeArrival,
                                    boolean nonStop,
                                    ZonedDateTime departureDate,
                                    ZonedDateTime arrivalDate) {
        return getFlightOffersPort
                .search(iataCodeDeparture,
                        iataCodeArrival,
                        departureDate,
                        arrivalDate,
                        1,
                        nonStop,
                        currencyCode);
    }

    private static List<ZonedDateTime> getSurroundingDays(ZonedDateTime date, int days) {
        List<ZonedDateTime> surroundingDays = new ArrayList<>();
        for (int i = -days; i <= days; i++) {
            var calculatedDate = date.plusDays(i);

            if (calculatedDate.isAfter(ZonedDateTime.now())) {
                surroundingDays.add(calculatedDate);
            }
        }
        return surroundingDays;
    }

    private void getFlightOffers(String iataCodeDeparture, String iataCodeArrival, boolean nonStop, ZonedDateTime departureDate, ZonedDateTime arrivalDate, ArrayList<FlightOffer> flightsOffers) {
        var searchOffers = search(iataCodeDeparture,
                iataCodeArrival,
                nonStop,
                departureDate,
                arrivalDate);

        if (searchOffers != null && !searchOffers.isEmpty()) {
            synchronized (flightsOffers) {
                flightsOffers.addAll(searchOffers);
            }
        }
    }
}