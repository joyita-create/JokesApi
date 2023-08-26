package com.example.joke.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Custom exception class to handle exceptions in the API.
 */
@Getter
public class JokeApiException extends Exception {

    private final String message;
    private final HttpStatus status;
    public JokeApiException(String message) {
        this.message = message;
        this.status = null;
    }
    public JokeApiException(){
        super();
        message = null;
        status = null;
    }

    public JokeApiException(String message, HttpStatus status){
        this.message = message;
        this.status = status;
    }
}
