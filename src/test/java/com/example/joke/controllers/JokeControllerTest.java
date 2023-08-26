package com.example.joke.controllers;

import com.example.joke.services.JokeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
class JokeControllerTest {

    @Mock
    JokeService jokeService;

    private MockMvc mockMvc;
    private JokeController jokeController;

    @BeforeEach
    public void setUp() {
        jokeController = new JokeController(jokeService);
        mockMvc = MockMvcBuilders.standaloneSetup(jokeController)
                .build();
    }

    @Test
    public void testGetRandomJoke_invalidUrl_returnsNotFound() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/jokes");
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void testGetRandomJoke_invalidUrl_returnsValidResponse() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/jokes/");
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(jokeService, Mockito.times(1))
                .getJoke();
    }


}