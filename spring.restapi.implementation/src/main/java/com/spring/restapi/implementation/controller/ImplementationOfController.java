package com.spring.restapi.implementation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restController")
public class ImplementationOfController {
    @GetMapping()
    public String displayText(){ //http"//localhost:9090/restController
        return "Welcome to RestController";
    }

    @GetMapping("/welcome")
    public ResponseEntity<String> getWelcomeMsg(){
    String msg = "Welcome To Ashok IT......";
    return new ResponseEntity<>(msg, HttpStatus.OK);
    }


}
