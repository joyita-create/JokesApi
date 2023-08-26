package com.example.joke.config;

import feign.Client;
import feign.httpclient.ApacheHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Feign client configuration.
 */
@Configuration
public class FeignConfiguration {

    @Bean
    public Client createClient() {
        return new ApacheHttpClient();
    }


}

