package br.com.lucaslima.flights.adapters.web.out.amadeus.flights.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record FareDetailsBySegmentDataAmadeusFlightOffersResponse(
        String segmentId,
        String cabin,
        String fareBasis,
        String brandedFare,
        String brandedFareLabel,
        @JsonProperty("class") String classfare,
        IncludedCheckedBagsFareDetailsBySegmentDataAmadeusFlightOffersResponse includedCheckedBags,
        List<AmenityFareDetailsBySegmentDataAmadeusFlightOffersResponse> amenities

) {
}
