package com.example.demo.controller;

import com.example.demo.request.PassengerRequest;
import com.example.demo.response.TicketResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * IRCTC Controller demonstrating HTTP methods and Idempotency
 * 
 * IDEMPOTENT: Making the same request multiple times produces the same result.
 * 
 * | Method  | Idempotent | Safe | Use Case                          |
 * |---------|------------|------|-----------------------------------|
 * | GET     | YES        | YES  | Retrieve data                     |
 * | PUT     | YES        | NO   | Update/Replace entire resource    |
 * | DELETE  | YES        | NO   | Remove resource                   |
 * | POST    | NO         | NO   | Create new resource               |
 * | PATCH   | NO         | NO   | Partial update                    |
 */
@RestController
@RequestMapping("/api/irctc")
@Tag(name = "IRCTC Ticket Booking", description = "APIs for booking, retrieving, updating, and cancelling train tickets")
public class IRCTCController {

    // In-memory storage to simulate database
    private Map<String, TicketResponse> ticketDatabase = new HashMap<>();

    // ═══════════════════════════════════════════════════════════════════════════
    // NON-IDEMPOTENT: POST - Creates a NEW ticket each time it's called
    // Calling POST 3 times = 3 different tickets created
    // ═══════════════════════════════════════════════════════════════════════════
    @Operation(summary = "Book a new ticket", description = "Creates a new train ticket booking. NON-IDEMPOTENT: Each call creates a new ticket with unique PNR.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ticket booked successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request data")
    })
    @PostMapping(value = "/bookticket",
            consumes = {"application/xml", "application/json"},
            produces = {"application/json", "application/xml"})
    public ResponseEntity<TicketResponse> bookTicket(@RequestBody PassengerRequest request) {
        
        TicketResponse response = new TicketResponse();
        
        // Generate unique PNR - different each time (non-idempotent behavior)
        String pnr = "PNR" + System.currentTimeMillis();
        
        response.setPnr(pnr);
        response.setStatus("Confirmed");
        response.setPrice(1500.0F);
        
        // Copy passenger details to response
        BeanUtils.copyProperties(request, response);
        
        // Store ticket in database
        ticketDatabase.put(pnr, response);
        
        // 201 CREATED - resource successfully created
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // IDEMPOTENT: GET - Retrieves ticket by PNR
    // Calling GET 100 times = same ticket returned every time (no side effects)
    // ═══════════════════════════════════════════════════════════════════════════
    @Operation(summary = "Get ticket by PNR", description = "Retrieves a ticket by its PNR number. IDEMPOTENT: Same result every time.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ticket found"),
            @ApiResponse(responseCode = "404", description = "Ticket not found")
    })
    @GetMapping(value = "/ticket/{pnr}",
            produces = {"application/json", "application/xml"})
    public ResponseEntity<TicketResponse> getTicketByPnr(
            @Parameter(description = "PNR number of the ticket") @PathVariable String pnr) {
        
        TicketResponse ticket = ticketDatabase.get(pnr);
        
        if (ticket == null) {
            // 404 NOT FOUND - ticket doesn't exist
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        // 200 OK - ticket found and returned
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // IDEMPOTENT: GET - Retrieves all tickets
    // Safe operation - doesn't modify any data
    // ═══════════════════════════════════════════════════════════════════════════
    @Operation(summary = "Get all tickets", description = "Retrieves all booked tickets. IDEMPOTENT: Safe read-only operation.")
    @ApiResponse(responseCode = "200", description = "List of all tickets")
    @GetMapping(value = "/tickets",
            produces = "application/json")
    public ResponseEntity<Collection<TicketResponse>> getAllTickets() {
        
        // Returns all tickets, calling multiple times gives same result
        return new ResponseEntity<>(ticketDatabase.values(), HttpStatus.OK);
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // IDEMPOTENT: PUT - Updates entire ticket resource
    // Calling PUT with same data multiple times = same final state
    // Example: Updating passenger name to "Rahul" 10 times = name is still "Rahul"
    // ═══════════════════════════════════════════════════════════════════════════
    @Operation(summary = "Update ticket", description = "Updates an existing ticket. IDEMPOTENT: Same input produces same result.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ticket updated successfully"),
            @ApiResponse(responseCode = "404", description = "Ticket not found")
    })
    @PutMapping(value = "/ticket/{pnr}",
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    public ResponseEntity<TicketResponse> updateTicket(
            @Parameter(description = "PNR number of the ticket to update") @PathVariable String pnr,
            @RequestBody PassengerRequest request) {
        
        TicketResponse existingTicket = ticketDatabase.get(pnr);
        
        if (existingTicket == null) {
            // 404 NOT FOUND - can't update non-existent ticket
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        // Update all fields from request (idempotent - same input = same output)
        BeanUtils.copyProperties(request, existingTicket);
        
        // Save updated ticket
        ticketDatabase.put(pnr, existingTicket);
        
        // 200 OK - ticket successfully updated
        return new ResponseEntity<>(existingTicket, HttpStatus.OK);
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // IDEMPOTENT: DELETE - Cancels/removes ticket
    // Calling DELETE multiple times = ticket remains deleted (same end state)
    // 1st call: Ticket deleted, returns 200 OK
    // 2nd call: Ticket already gone, returns 404 NOT FOUND (but end state is same)
    // ═══════════════════════════════════════════════════════════════════════════
    @Operation(summary = "Cancel ticket", description = "Cancels/deletes a ticket. IDEMPOTENT: End state is always 'ticket deleted'.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ticket cancelled successfully"),
            @ApiResponse(responseCode = "404", description = "Ticket not found")
    })
    @DeleteMapping(value = "/ticket/{pnr}",
            produces = "application/json")
    public ResponseEntity<String> cancelTicket(
            @Parameter(description = "PNR number of the ticket to cancel") @PathVariable String pnr) {
        
        TicketResponse removedTicket = ticketDatabase.remove(pnr);
        
        if (removedTicket == null) {
            // 404 NOT FOUND - ticket doesn't exist (already deleted or never existed)
            return new ResponseEntity<>("Ticket with PNR " + pnr + " not found", HttpStatus.NOT_FOUND);
        }
        
        // 200 OK - ticket successfully cancelled
        return new ResponseEntity<>("Ticket " + pnr + " cancelled successfully", HttpStatus.OK);
    }
}
