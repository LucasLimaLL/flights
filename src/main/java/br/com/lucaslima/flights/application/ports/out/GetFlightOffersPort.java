package br.com.lucaslima.flights.application.ports.out;

import br.com.lucaslima.flights.application.domain.FlightOffer;

import java.time.ZonedDateTime;
import java.util.List;

public interface GetFlightOffersPort {

    List<FlightOffer> search(
            String iataCodeDeparture,
            String iataCodeArrival,
            ZonedDateTime departureDate,
            int adults,
            boolean nonStop,
            String currencyCode);

    List<FlightOffer> search(
            String iataCodeDeparture,
            String iataCodeArrival,
            ZonedDateTime departureDate,
            ZonedDateTime returnDate,
            int adults,
            boolean nonStop,
            String currencyCode);
}
