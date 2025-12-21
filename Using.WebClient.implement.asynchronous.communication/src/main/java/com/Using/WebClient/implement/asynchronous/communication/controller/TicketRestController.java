package com.Using.WebClient.implement.asynchronous.communication.controller;

import com.Using.WebClient.implement.asynchronous.communication.binding.PassengerRequest;
import com.Using.WebClient.implement.asynchronous.communication.binding.TicketResponse;
import com.Using.WebClient.implement.asynchronous.communication.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
@RequestMapping("/ticket")
public class TicketRestController {

    @Autowired
    private TicketService ticketService;

    // Sync endpoint - blocks until response
    @PostMapping("/sync")
    public TicketResponse getDisplayTicketInformation(@RequestBody PassengerRequest request) {
        return ticketService.initiateTicketBookProcess(request);
    }

    // Async endpoint - returns TicketResponse via DeferredResult
    @PostMapping("/async")
    public DeferredResult<TicketResponse> bookTicketAsync(@RequestBody PassengerRequest request) {
        return ticketService.initiateTicketBookProcessAsync(request);
    }
}
