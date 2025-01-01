package br.com.lucaslima.flights.adapters.web.out.amadeus.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AuthAmadeusResponse(
        String type,
        String username,
        @JsonProperty("application_name") String applicationName,
        @JsonProperty("client_id") String clientId,
        @JsonProperty("token_type") String tokenType,
        @JsonProperty("access_token") String accessToken,
        @JsonProperty("expires_in") int expiresIn,
        String state,
        String scope
) {
}
