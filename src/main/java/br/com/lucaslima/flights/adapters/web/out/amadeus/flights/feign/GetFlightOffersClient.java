package br.com.lucaslima.flights.adapters.web.out.amadeus.flights.feign;

import br.com.lucaslima.flights.adapters.web.out.amadeus.flights.dto.AmadeusFlightOffersResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "get-flight-offers-client",
        url = "${http.amadeus.flights.url}",
        configuration = GetFlightOffersClientConfiguration.class)
public interface GetFlightOffersClient {

    @GetMapping(path = "/v2/shopping/flight-offers")
    ResponseEntity<AmadeusFlightOffersResponse> getFlightOffers(
            @RequestParam("originLocationCode") String originLocationCode,
            @RequestParam("destinationLocationCode") String destinationLocationCode,
            @RequestParam("departureDate") String departureDate,
            @RequestParam("adults") int adults,
            @RequestParam("nonStop") boolean nonStop,
            @RequestParam("currencyCode") String currencyCode
    );

}
