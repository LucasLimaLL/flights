package br.com.lucaslima.flights.adapters.web.out.amadeus.flights.dto;

import java.util.Map;

public record DictionaryAmadeusFlightOffersResponse(
        Map<String, Object> locations,
        Map<String, Object> aircraft,
        Map<String, Object> currencies,
        Map<String, Object> carriers
) {
}
