package br.com.lucaslima.flights.adapters.web.out.amadeus.flights.dto;

import java.time.ZonedDateTime;

public record ArrivalSegmentItineraryDataAmadeusFlightOffersResponse(
        String iataCode,
        String terminal,
        ZonedDateTime at
) {
}
