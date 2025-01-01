package br.com.lucaslima.flights.adapters.web.out.amadeus.flights.dto;

import java.math.BigDecimal;
import java.util.List;

public record PriceDataAmadeusFlightOffersResponse(
        String currency,
        BigDecimal total,
        BigDecimal base,
        List<FeePriceDataAmadeusFlightOffersResponse> fees,
        BigDecimal grandTotal,
        List<AdditionalServicesPriceDataAmadeusFlightOffersResponse> additionalServices

) {
}
