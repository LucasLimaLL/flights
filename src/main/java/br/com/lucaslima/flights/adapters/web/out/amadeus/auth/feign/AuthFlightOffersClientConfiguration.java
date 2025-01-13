package br.com.lucaslima.flights.adapters.web.out.amadeus.auth.feign;

import br.com.lucaslima.flights.adapters.web.out.feign.DefaultFeignClientConfiguration;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthFlightOffersClientConfiguration extends DefaultFeignClientConfiguration {

    @Bean
    public Encoder encoder(ObjectFactory<HttpMessageConverters> converters) {
        return new SpringFormEncoder(new SpringEncoder(converters));
    }

}