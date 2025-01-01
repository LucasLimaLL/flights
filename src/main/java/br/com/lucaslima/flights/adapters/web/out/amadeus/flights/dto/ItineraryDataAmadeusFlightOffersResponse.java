package br.com.lucaslima.flights.adapters.web.out.amadeus.flights.dto;

import java.time.Duration;
import java.util.List;

public record ItineraryDataAmadeusFlightOffersResponse(
        Duration duration,
        List<SegmentItineraryDataAmadeusFlightOffersResponse> segments
) {
}
