package br.com.lucaslima.flights.adapters.web.out.amadeus.auth.feign;

import br.com.lucaslima.flights.adapters.web.out.amadeus.auth.dto.AuthAmadeusRequest;
import br.com.lucaslima.flights.adapters.web.out.amadeus.auth.dto.AuthAmadeusResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "auth-flight-offers-client",
        url = "${http.amadeus.auth.url}",
        configuration = AuthFlightOffersClientConfiguration.class)
public interface AuthAmadeusFeignClient {

    @PostMapping(
            path = "/v1/security/oauth2/token",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    ResponseEntity<AuthAmadeusResponse> token(
            @RequestBody AuthAmadeusRequest authAmadeusRequest);
}