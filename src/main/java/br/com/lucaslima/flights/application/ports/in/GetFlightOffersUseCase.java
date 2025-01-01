package br.com.lucaslima.flights.application.ports.in;

import br.com.lucaslima.flights.application.domain.FlightOffer;

import java.time.ZonedDateTime;
import java.util.List;

public interface GetFlightOffersUseCase {

    List<FlightOffer> search(
            String iataCodeDeparture,
            String iataCodeArrival,
            boolean nonStop,
            int daysToDeparture,
            ZonedDateTime desiredDate,
            int precision);

    List<FlightOffer> search(
            String iataCodeDeparture,
            String iataCodeArrival,
            boolean nonStop,
            ZonedDateTime departureDate,
            ZonedDateTime arrivalDate);

}
