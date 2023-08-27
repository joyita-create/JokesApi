package com.example.joke.controllers;

import com.example.joke.dto.JokeDetail;
import com.example.joke.exceptions.JokeApiException;
import com.example.joke.services.JokeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Joke controller.
 */
@RestController
@RequestMapping(path = "/jokes")
@AllArgsConstructor
/**
 JokeController for Joke resource.
 */
public class JokeController {


    private JokeService jokeService;


    /**
     * Gets random joke.
     *
     * @return the random joke
     * @throws JokeApiException the joke api exception
     */
    @GetMapping(path = "/")
    public JokeDetail getRandomJoke() throws JokeApiException {
        return (jokeService.getJoke());

    }


}
