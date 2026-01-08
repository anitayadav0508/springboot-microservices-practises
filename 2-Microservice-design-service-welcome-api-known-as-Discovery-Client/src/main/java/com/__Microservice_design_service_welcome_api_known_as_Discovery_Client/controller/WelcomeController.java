package com.__Microservice_design_service_welcome_api_known_as_Discovery_Client.controller;

import com.__Microservice_design_service_welcome_api_known_as_Discovery_Client.client.GreetClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {

    @Autowired
    private GreetClient greetClient;

    @GetMapping("/message")
    public String welcomeMessage(){
        String welcomeMsg =  "Welcome to Microservice Project!!";

       String greetMsg =  greetClient.invokeGreetApi();

       return welcomeMsg + " " + greetMsg ;
    }



}
