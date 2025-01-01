package br.com.lucaslima.flights.adapters.web.out.amadeus.flights.dto;

import java.util.List;

public record AmadeusFlightOffersResponse(
        MetaAmadeusFlightOffersResponse meta,
        List<DataAmadeusFlightOffersResponse> data) {
}
