package br.com.lucaslima.flights.adapters.web.out.amadeus.flights.dto;

import java.math.BigDecimal;

public record FeePriceDataAmadeusFlightOffersResponse(
        BigDecimal amount,
        String type
) {
}
