package com.example.joke.services;

import com.example.joke.dto.JokeDetail;
import com.example.joke.exceptions.JokeApiException;
import com.example.joke.utils.AppConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

/**
 * The type Joke service.
 */
@Slf4j
@Service

public class JokeService {


    private final ExternalApiService externalApiService;

    /**
     * Instantiates a new Joke service.
     *
     * @param externalApiService the external api service
     */
    public JokeService(ExternalApiService externalApiService) {
        this.externalApiService = externalApiService;
    }


    /**
     * Gets the shortest joke which is safe to display.
     *
     * @return the joke
     * @throws JokeApiException the joke api exception
     */
    public JokeDetail getJoke() throws JokeApiException {
        Optional<JokeDetail> joke = Optional.ofNullable(externalApiService.getRandomJokes().getJokes())
                .orElse(new ArrayList<>())
                .stream()
                .filter(jokeDetail -> (jokeDetail.isSafe() && (!jokeDetail.getFlags().isExplicit() &&
                        !jokeDetail.getFlags().isSexist()))
                )
                .min(Comparator.comparing(jokeDetail -> jokeDetail.getRandomJoke().length()));
        if (joke.isEmpty()) {
            throw new JokeApiException(AppConstants.JOKE_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        return joke.get();
    }
}
