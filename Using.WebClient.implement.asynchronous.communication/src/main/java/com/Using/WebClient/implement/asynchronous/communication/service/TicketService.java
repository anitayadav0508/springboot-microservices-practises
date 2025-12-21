package com.Using.WebClient.implement.asynchronous.communication.service;

import com.Using.WebClient.implement.asynchronous.communication.binding.PassengerRequest;
import com.Using.WebClient.implement.asynchronous.communication.binding.TicketResponse;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class TicketService {

    // Sync method - blocks until response arrives
    public TicketResponse initiateTicketBookProcess(PassengerRequest requestData) {
        String endPointUrl = "http://localhost:9090/api/irctc/bookticket";
        WebClient webClient = WebClient.create();
        TicketResponse ticket = webClient.post()
                .uri(endPointUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(requestData)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> {
                    System.out.println("Client Error: " + clientResponse.statusCode());
                    return Mono.error(new RuntimeException("Client Error"));
                })
                .onStatus(HttpStatusCode::is5xxServerError, clientResponse -> {
                    System.out.println("Server Error: " + clientResponse.statusCode());
                    return Mono.error(new RuntimeException("Server Error"));
                })
                .bodyToMono(TicketResponse.class)
                .block();
        return ticket;
    }

    // Async method using subscribe - returns TicketResponse via DeferredResult
    public DeferredResult<TicketResponse> initiateTicketBookProcessAsync(PassengerRequest requestData) {
        String endPointUrl = "http://localhost:9090/api/irctc/bookticket";
        WebClient webClient = WebClient.create();

        DeferredResult<TicketResponse> deferredResult = new DeferredResult<>();

        webClient.post()
                .uri(endPointUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(requestData)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> {
                    System.out.println("Client Error: " + clientResponse.statusCode());
                    return Mono.error(new RuntimeException("Client Error"));
                })
                .onStatus(HttpStatusCode::is5xxServerError, clientResponse -> {
                    System.out.println("Server Error: " + clientResponse.statusCode());
                    return Mono.error(new RuntimeException("Server Error"));
                })
                .bodyToMono(TicketResponse.class)
                .subscribe(
                        ticket -> handleTicketResponse(ticket, deferredResult),  // onNext - success
                        error -> handleError(error, deferredResult)              // onError - failure
                );

        System.out.println("************ Async Request Sent *************");
        return deferredResult;
    }

    // Handler for successful response
    public static void handleTicketResponse(TicketResponse ticket, DeferredResult<TicketResponse> deferredResult) {
        System.out.println("******** Ticket Booked Successfully ********");
        System.out.println(ticket);
        deferredResult.setResult(ticket);  // Complete and return TicketResponse to client
    }

    // Handler for errors
    public static void handleError(Throwable error, DeferredResult<TicketResponse> deferredResult) {
        System.out.println("******** Ticket Booking Failed ********");
        System.out.println("Error: " + error.getMessage());
        deferredResult.setErrorResult(error);
    }
}
