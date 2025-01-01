package br.com.lucaslima.flights.adapters.web.out.amadeus.flights.dto;

import java.util.List;

public record TravelerPricingsDataAmadeusFlightOffersResponse(
        String travelerId,
        String fareOption,
        String travelerType,
        PriceDataAmadeusFlightOffersResponse price,
        List<FareDetailsBySegmentDataAmadeusFlightOffersResponse> fareDetailsBySegment
) {
}
