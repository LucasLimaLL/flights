package br.com.lucaslima.flights.adapters.web.out.amadeus.flights.feign;

import br.com.lucaslima.flights.adapters.web.out.auth.AuthPort;
import br.com.lucaslima.flights.adapters.web.out.feign.DefaultFeignClientConfiguration;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

@Configuration
public class GetFlightOffersClientConfiguration extends DefaultFeignClientConfiguration {

    private final AuthPort authPort;

    public GetFlightOffersClientConfiguration(AuthPort authPort) {
        this.authPort = authPort;
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header(HttpHeaders.AUTHORIZATION, "Bearer " + authPort.getAccessToken());
            requestTemplate.header(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate, br");
        };
    }

}
