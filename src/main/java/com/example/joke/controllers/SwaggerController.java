package com.example.joke.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * SwggerController
 * Landing page of application provides swagger-ui to test API
 */
@Controller
public class SwaggerController {
    /**
     * Redirects landing page to swagger-ui
     * @return redirect to /swagger-ui/index.html?url=/v3/api-docs
     */
    @RequestMapping("/api-docs")
    public String swaggerUI(){
        return "redirect:/swagger-ui/index.html?url=/v3/api-docs";
    }
}
