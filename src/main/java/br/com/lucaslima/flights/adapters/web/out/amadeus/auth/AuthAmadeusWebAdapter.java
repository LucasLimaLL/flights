package br.com.lucaslima.flights.adapters.web.out.amadeus.auth;

import br.com.lucaslima.flights.adapters.web.out.amadeus.auth.feign.AuthAmadeusFeignClient;
import br.com.lucaslima.flights.adapters.web.out.amadeus.auth.properties.AuthProperties;
import br.com.lucaslima.flights.adapters.web.out.auth.AuthPort;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties(AuthProperties.class)
public class AuthAmadeusWebAdapter implements AuthPort {

    private final AuthAmadeusFeignClient authAmadeusFeignClient;
    private final AuthProperties authProperties;

    public AuthAmadeusWebAdapter(AuthProperties authProperties,
                                 AuthAmadeusFeignClient authAmadeusFeignClient) {
        this.authProperties = authProperties;
        this.authAmadeusFeignClient = authAmadeusFeignClient;
    }

    @Override
    public String getAccessToken() {

        var response = authAmadeusFeignClient.token(
                authProperties.getClientId(),
                authProperties.getClientSecret(),
                authProperties.getGrantType()
        );

        return response.getBody().accessToken();
    }
}
