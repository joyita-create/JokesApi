package com.example.joke.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JokeDetail {
    String id;
    @JsonAlias({ "joke" })
    String randomJoke;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    boolean safe;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    Flags flags;
}
