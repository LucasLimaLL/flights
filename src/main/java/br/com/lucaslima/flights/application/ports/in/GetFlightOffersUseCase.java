package br.com.lucaslima.flights.application.ports.in;

import br.com.lucaslima.flights.application.domain.FlightOffer;

import java.time.ZonedDateTime;
import java.util.List;

public interface GetFlightOffersUseCase {

    List<FlightOffer> search(
            String iataCodeDeparture,
            String iataCodeArrival,
            int daysToDeparture,
            ZonedDateTime departureDate,
            int precision);

}
