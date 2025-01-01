package br.com.lucaslima.flights.adapters.web.out.amadeus.auth.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
@ConfigurationProperties(prefix = "http.amadeus.auth")
public class AuthProperties {

    private String url;
    private String clientId;
    private String clientSecret;
    private String grantType;
}
