package com.example.joke.controllers.advice;

import com.example.joke.exceptions.JokeApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * ControllerAdvice class to create custom response for exceptions.
 */
@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Create custom response for JokeApiException class.
     *
     * @param jokeApiException type of exception.
     * @return response entity with error message and status.
     */
    @ExceptionHandler(JokeApiException.class)
    public final ResponseEntity<String> handleException(JokeApiException jokeApiException) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        if (jokeApiException.getStatus() != null) {
            status = jokeApiException.getStatus();
        }
        log.error(jokeApiException.getMessage());
        return new ResponseEntity<>(jokeApiException.getMessage(), status);

    }


}
