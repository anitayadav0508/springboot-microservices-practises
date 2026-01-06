package com.__Microservice_design_service_welcome_api_known_as_Discovery_Client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {

    @GetMapping("/message")
    public String welcomeMessage(){
        return "Welcome to Microservice Project!!";
    }
}
