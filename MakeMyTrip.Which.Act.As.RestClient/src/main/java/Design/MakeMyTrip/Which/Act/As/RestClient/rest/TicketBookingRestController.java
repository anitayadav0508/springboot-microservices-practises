package Design.MakeMyTrip.Which.Act.As.RestClient.rest;

import Design.MakeMyTrip.Which.Act.As.RestClient.request.PassengerRequest;
import Design.MakeMyTrip.Which.Act.As.RestClient.response.TicketResponse;
import Design.MakeMyTrip.Which.Act.As.RestClient.service.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Tag(name = "Ticket Booking", description = "APIs for booking train tickets")
public class TicketBookingRestController {

    @Autowired
    private TicketService ticketService;

    @Operation(
            summary = "Book a train ticket",
            description = "Books a train ticket for a passenger with the provided travel details. Returns ticket information including PNR, status, and price."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Ticket booked successfully",
                    content = @Content(schema = @Schema(implementation = TicketResponse.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request data",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content
            )
    })
    @PostMapping("/book")
    public TicketResponse bookTicket(@RequestBody PassengerRequest passengerRequest) {
        return this.ticketService.initiateTicketBookProcess(passengerRequest);
    }
}
