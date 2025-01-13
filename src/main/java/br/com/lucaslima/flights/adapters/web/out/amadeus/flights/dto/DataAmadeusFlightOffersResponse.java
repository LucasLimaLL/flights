package br.com.lucaslima.flights.adapters.web.out.amadeus.flights.dto;

import java.util.List;

public record DataAmadeusFlightOffersResponse(
        String type,
        String id,
        String source,
        boolean instantTicketingRequired,
        boolean nonHomogeneous,
        boolean oneWay,
        boolean isUpsellOffer,
        String lastTicketingDate,
        String lastTicketingDateTime,
        int numberOfBookableSeats,
        List<ItineraryDataAmadeusFlightOffersResponse> itineraries,
        PriceDataAmadeusFlightOffersResponse price,
        PricingOptionsDataAmadeusFlightOffersResponse pricingOptions,
        List<String> validatingAirlineCodes
) {
}
