package br.com.lucaslima.flights.application.service;

import br.com.lucaslima.flights.application.domain.FlightOffer;
import br.com.lucaslima.flights.application.ports.in.GetFlightOffersUseCase;
import br.com.lucaslima.flights.application.ports.out.GetFlightOffersPort;

import java.time.ZonedDateTime;
import java.util.List;

public class GetFlightOffersService implements GetFlightOffersUseCase {

    private final GetFlightOffersPort getFlightOffersPort;
    private final String currencyCode;

    public GetFlightOffersService(GetFlightOffersPort getFlightOffersPort) {
        this.getFlightOffersPort = getFlightOffersPort;
        this.currencyCode = "BRL";
    }


    @Override
    public List<FlightOffer> search(String iataCodeDeparture,
                                    String iataCodeArrival,
                                    boolean nonStop,
                                    int daysToDeparture,
                                    ZonedDateTime departureDate,
                                    int precision) {
        return List.of();
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
}
