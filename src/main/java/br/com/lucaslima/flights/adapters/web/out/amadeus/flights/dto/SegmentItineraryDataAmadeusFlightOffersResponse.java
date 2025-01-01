package br.com.lucaslima.flights.adapters.web.out.amadeus.flights.dto;

import java.time.Duration;

public record SegmentItineraryDataAmadeusFlightOffersResponse(
        DepartureSegmentItineraryDataAmadeusFlightOffersResponse departure,
        ArrivalSegmentItineraryDataAmadeusFlightOffersResponse arrival,
        String carrierCode,
        String number,
        AircraftSegmentItineraryDataAmadeusFlightOffersResponse aircraft,
        Duration duration,
        String id,
        int numberOfStops,
        boolean blacklistedInEU
) {
}
