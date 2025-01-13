package br.com.lucaslima.flights.adapters.web.out.amadeus.auth;

import br.com.lucaslima.flights.adapters.web.out.amadeus.auth.dto.AuthAmadeusRequest;
import br.com.lucaslima.flights.adapters.web.out.amadeus.auth.dto.AuthAmadeusResponse;
import br.com.lucaslima.flights.adapters.web.out.amadeus.auth.dto.AuthAmadeusResponseSupport;
import br.com.lucaslima.flights.adapters.web.out.amadeus.auth.feign.AuthAmadeusFeignClient;
import br.com.lucaslima.flights.adapters.web.out.amadeus.auth.properties.AuthProperties;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AuthAmadeusWebAdapterTest {

    private AuthAmadeusFeignClient authAmadeusFeignClient;
    private AuthProperties authProperties;
    private AuthAmadeusWebAdapter authAmadeusWebAdapter;

    @BeforeEach
    void setUp() {
        authAmadeusFeignClient = Mockito.mock(AuthAmadeusFeignClient.class);
        authProperties = new AuthProperties();
        authProperties.setClientId("testClientId");
        authProperties.setClientSecret("testClientSecret");
        authProperties.setGrantType("client_credentials");
        authAmadeusWebAdapter = new AuthAmadeusWebAdapter(authProperties, authAmadeusFeignClient);
    }

    @Test
    @DisplayName("Should return access token when response is valid")
    void shouldReturnAccessTokenWhenResponseIsValid() {
        AuthAmadeusResponse response = AuthAmadeusResponseSupport.create();

        when(authAmadeusFeignClient.token(any(AuthAmadeusRequest.class))).thenReturn(ResponseEntity.ok(response));

        String accessToken = authAmadeusWebAdapter.getAccessToken();

        assertEquals("JjzW05seOzKAw6nK44oToZ_XKuVCRB_AmGHTu8Nb8Gc", accessToken);
        verify(authAmadeusFeignClient, times(1)).token(any(AuthAmadeusRequest.class));
    }

    @Test
    @DisplayName("Should throw NullPointerException when response body is null")
    void shouldThrowNullPointerExceptionWhenResponseBodyIsNull() {
        when(authAmadeusFeignClient.token(any(AuthAmadeusRequest.class)))
                .thenReturn(ResponseEntity.ok(null));

        var e = assertThrows(Exception.class, () -> authAmadeusWebAdapter.getAccessToken());

        assertAll(
                () -> assertInstanceOf(NullPointerException.class, e),
                () -> verify(authAmadeusFeignClient, times(1)).token(any(AuthAmadeusRequest.class))
        );
    }

}