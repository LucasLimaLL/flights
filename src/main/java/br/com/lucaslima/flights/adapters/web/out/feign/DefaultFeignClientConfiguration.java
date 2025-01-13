package br.com.lucaslima.flights.adapters.web.out.feign;

import feign.Retryer;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.concurrent.TimeUnit.SECONDS;

@Configuration
public class DefaultFeignClientConfiguration {

    private static final int MAX_ATTEMPTS = 5;

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient();
    }

    @Bean
    public Retryer retryer() {
        return new Retryer.Default(100, SECONDS.toMillis(1), MAX_ATTEMPTS);
    }
}
