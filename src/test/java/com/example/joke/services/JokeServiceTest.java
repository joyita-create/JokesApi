package com.example.joke.services;

import com.example.joke.dto.JokeDetail;
import com.example.joke.dto.JokeResponse;
import com.example.joke.exceptions.JokeApiException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;

import static com.example.joke.utils.AppConstants.JOKE_NOT_FOUND;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class JokeServiceTest {

    @Mock
    private ExternalApiService externalApiService;


    private JokeService jokeService;

    @BeforeEach
    public void setUp() {

        jokeService = new JokeService(externalApiService);
    }

    @Test
    public void testGetJoke_whenExternalApiThrowsException_thenThrowException() throws JokeApiException {
        Mockito.when(externalApiService.getRandomJokes()).thenThrow(new JokeApiException());
        Assertions.assertThrows(JokeApiException.class,
                () -> jokeService.getJoke());

    }

    @Test
    public void testGetJoke_whenNoSafeJoke_thenReturnNotFoundException() throws JokeApiException {
        JokeResponse jokeResponse = new JokeResponse();
        jokeResponse.setJokes(new ArrayList<>());
        jokeResponse.getJokes().add(new JokeDetail("1", "Joke1", false));
        Mockito.when(externalApiService.getRandomJokes()).thenReturn(jokeResponse);
        JokeApiException exception = Assertions.assertThrows(JokeApiException.class,
                () -> jokeService.getJoke());
        assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());
        assertEquals(JOKE_NOT_FOUND, exception.getMessage());

    }

    @Test
    public void testGetJoke_whenMultipleJokes_thenReturnSafeJokeWithShortestText() throws JokeApiException {
        JokeResponse jokeResponse = new JokeResponse();
        jokeResponse.setJokes(new ArrayList<>());
        jokeResponse.getJokes().add(new JokeDetail("1", "Joke1", false));
        jokeResponse.getJokes().add(new JokeDetail("2", "Joke123", true));
        jokeResponse.getJokes().add(new JokeDetail("3", "Joke12345", true));

        Mockito.when(externalApiService.getRandomJokes()).thenReturn(jokeResponse);
        org.assertj.core.api.Assertions.assertThat(jokeService.getJoke())
                .hasFieldOrPropertyWithValue("joke", "Joke123")
                .hasFieldOrPropertyWithValue("id", "2");
    }


}
