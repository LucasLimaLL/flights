package br.com.lucaslima.flights.adapters.web.out.amadeus.auth.feign;

import br.com.lucaslima.flights.adapters.web.out.amadeus.auth.dto.AuthAmadeusResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "auth-flight-offers-client",
        url = "${http.amadeus.auth.url}",
        configuration = AuthFlightOffersClientConfiguration.class)
public interface AuthAmadeusFeignClient {

    @PostMapping(path = "v1/security/oauth2/token", consumes = "application/x-www-form-urlencoded")
    ResponseEntity<AuthAmadeusResponse> token(
            @RequestParam("client_id") String clientId,
            @RequestParam("client_secret") String clientSecret,
            @RequestParam("grant_type") String grantType);
}
