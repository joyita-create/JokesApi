package com.example.joke.controllers;

import com.example.joke.dto.JokeDetail;
import com.example.joke.dto.JokeResponse;
import com.example.joke.exceptions.JokeApiException;
import com.example.joke.services.JokeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/jokes")
@AllArgsConstructor
/**
 JokeController for movie resource.
 */
public class JokeController {


    private JokeService jokeService;


    @GetMapping(path = "/")
    public JokeDetail getRandomJoke() throws JokeApiException {
        return (jokeService.getJoke());

    }


}
