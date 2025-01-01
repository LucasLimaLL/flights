package br.com.lucaslima.flights.adapters.web.out.amadeus.flights.feign;

import br.com.lucaslima.flights.adapters.web.out.feign.DefaultFeignClientConfiguration;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetFlightOffersClientConfiguration extends DefaultFeignClientConfiguration {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Authorization", "Bearer ${http.amadeus.api-key}");
        };
    }

}
