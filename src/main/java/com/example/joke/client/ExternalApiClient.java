package com.example.joke.client;

import com.example.joke.config.FeignConfiguration;
import com.example.joke.dto.JokeResponse;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign client for External joke API.
 */
@FeignClient(value = "externalApiClient", url = "${api.externalapi.url}",
        configuration = FeignConfiguration.class)
@Headers({"Content-Type: application/json"})
public interface ExternalApiClient {


    /**
     * Gets jokes.
     *
     * @param amount the amount
     * @param type   the type
     * @return the jokes
     */
    @GetMapping
    ResponseEntity<JokeResponse> getJokes(
            @RequestParam(name = "amount") String amount,
            @RequestParam(name = "type") String type);

}
