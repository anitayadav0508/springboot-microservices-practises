package com.Using.WebClient.implement.asynchronous.communication.controller;

import com.Using.WebClient.implement.asynchronous.communication.service.CustomerEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class CustomerEventController {

    @Autowired
    private CustomerEventService eventService;

    @GetMapping("/flux")
    public void displayFlexRequestData(){
        eventService.invokeFluxCustomerEvent();

    }

    @GetMapping("/mono")
    public void displayMonoRequestData(){
        eventService.invokeMonoCustomerEvents();

    }
}
