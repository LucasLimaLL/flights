package br.com.lucaslima.flights.adapters.web.out.amadeus.flights.dto;

public record AmenityFareDetailsBySegmentDataAmadeusFlightOffersResponse(
        String description,
        boolean isChargeable,
        String amenityType,
        AmenityProviderFareDetailsBySegmentDataAmadeusFlightOffersResponse amenityProvider
) {
}
