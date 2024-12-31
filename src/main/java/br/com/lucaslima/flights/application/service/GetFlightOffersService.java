package br.com.lucaslima.flights.application.service;

import br.com.lucaslima.flights.application.domain.FlightOffer;
import br.com.lucaslima.flights.application.ports.in.GetFlightOffersUseCase;

import java.time.ZonedDateTime;
import java.util.List;

public class GetFlightOffersService implements GetFlightOffersUseCase {

    @Override
    public List<FlightOffer> search(String iataCodeDeparture, String iataCodeArrival, int daysToDeparture, ZonedDateTime departureDate, int precision) {
        return List.of();
    }
}
