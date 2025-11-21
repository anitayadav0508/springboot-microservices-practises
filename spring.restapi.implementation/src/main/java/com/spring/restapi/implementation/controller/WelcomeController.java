package com.spring.restapi.implementation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {

    @GetMapping()
    public String getGreetMsg(){  // http://localhost:9090/welcome
        return "Welcome to first Rest Api Project";
    }

    @GetMapping("/wish")
    public String wish(){ //http://localhost:9090/welcome/wish
        return "Good morning!!";
    }

    @GetMapping("/quote")
    public String getQuote(){ //http"//localhost:9090/welcome
        return "Do or Die!!";
    }
}
