package com.example.joke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * JokeApplication
 * Spring boot application start class
 */
@SpringBootApplication(scanBasePackages = {"com.example.joke"})
@EnableFeignClients
public class JokeApplication {
    public static void main(String[] args) {
        SpringApplication.run(JokeApplication.class, args);
    }
}




