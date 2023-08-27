package com.example.joke.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * The type Joke response.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JokeResponse {
    /**
     * The Error.
     */
    String error;
    /**
     * The Amount.
     */
    String amount;
    /**
     * The Jokes.
     */
    List<JokeDetail> jokes;
}
