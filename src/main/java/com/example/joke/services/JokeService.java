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
 * JokeService
 * Contains all the Business logic regarding Movie.
 */
@Slf4j
@Service

public class JokeService {


    private final ExternalApiService externalApiService;

    public JokeService(ExternalApiService externalApiService) {
        this.externalApiService = externalApiService;
    }


    public JokeDetail getJoke() throws JokeApiException {
        Optional<JokeDetail> joke = Optional.ofNullable(externalApiService.getRandomJokes().getJokes())
                .orElse(new ArrayList<>())
                .stream()
                .filter(jokeDetail -> (jokeDetail.isSafe() && (!jokeDetail.getFlags().isExplicit() &&
                        !jokeDetail.getFlags().isSexist()))
                )
                .sorted(Comparator.comparing(jokeDetail -> jokeDetail.getRandomJoke().length()))
                .findFirst();
        if (joke.isEmpty()) {
            throw new JokeApiException(AppConstants.JOKE_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        return joke.get();
    }
}
