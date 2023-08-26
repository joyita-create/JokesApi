package com.example.joke.services;

import com.example.joke.client.ExternalApiClient;
import com.example.joke.dto.JokeResponse;
import com.example.joke.exceptions.JokeApiException;
import com.example.joke.utils.AppConstants;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ExternalApiService {

    private final ExternalApiClient externalApiClient;

    public ExternalApiService(ExternalApiClient externalApiClient) {
        this.externalApiClient = externalApiClient;
    }


    public JokeResponse getRandomJokes() throws JokeApiException {
        try {
            ResponseEntity<JokeResponse> response = externalApiClient.getJokes("16", "single");
            return response.getBody();
        } catch (FeignException fe) {
            log.error("Exception occured in calling external service", fe.getMessage());
            throw new JokeApiException(AppConstants.EXTERNAL_API_EXCEPTION);
        }
    }

}
