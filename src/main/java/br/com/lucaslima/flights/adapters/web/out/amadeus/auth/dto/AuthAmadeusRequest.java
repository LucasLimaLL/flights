package br.com.lucaslima.flights.adapters.web.out.amadeus.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import feign.form.FormProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthAmadeusRequest {

    @JsonProperty("client_id")
    @FormProperty("client_id")
    String clientId;

    @JsonProperty("client_secret")
    @FormProperty("client_secret")
    String clientSecret;

    @JsonProperty("grant_type")
    @FormProperty("grant_type")
    String grantType;
}
