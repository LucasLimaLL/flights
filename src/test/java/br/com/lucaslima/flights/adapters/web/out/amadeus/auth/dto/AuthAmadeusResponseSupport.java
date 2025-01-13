package br.com.lucaslima.flights.adapters.web.out.amadeus.auth.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

public class AuthAmadeusResponseSupport {

    @SneakyThrows
    public static AuthAmadeusResponse create() {
        return new ObjectMapper()
                .readValue("""
                        {
                            "type": "amadeusOAuth2Token",
                            "username": "teste@test.com",
                            "application_name": "AppName",
                            "client_id": "TrQ8kYwqq0G4HW3rEf8groRO664IQ1zYcnTyH",
                            "token_type": "Bearer",
                            "access_token": "JjzW05seOzKAw6nK44oToZ_XKuVCRB_AmGHTu8Nb8Gc",
                            "expires_in": 1799,
                            "state": "approved",
                            "scope": ""
                        }
                        """, AuthAmadeusResponse.class);
    }

}