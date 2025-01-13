package br.com.lucaslima.flights.adapters.web.out.amadeus.flights.dto;

import java.time.LocalDateTime;

public record DepartureSegmentItineraryDataAmadeusFlightOffersResponse(
        String iataCode,
        String terminal,
        LocalDateTime at
) {
}
