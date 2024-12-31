package br.com.lucaslima.flights.configuration;

import br.com.lucaslima.flights.application.ports.in.GetFlightOffersUseCase;
import br.com.lucaslima.flights.application.ports.out.GetFlightOffersPort;
import br.com.lucaslima.flights.application.service.GetFlightOffersService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlightBeansConfiguration {

    @Bean
    public GetFlightOffersUseCase beanGetFlightOffersUseCase(GetFlightOffersPort getFlightOffersPort) {
        return new GetFlightOffersService(getFlightOffersPort);
    }
}
