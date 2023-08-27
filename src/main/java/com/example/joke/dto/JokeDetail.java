package com.example.joke.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Joke detail.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JokeDetail {
    /**
     * The Id.
     */
    String id;
    /**
     * The Random joke.
     */
    @JsonAlias({ "joke" })
    String randomJoke;
    /**
     * The Safe.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    boolean safe;
    /**
     * The Flags.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    Flags flags;
}
