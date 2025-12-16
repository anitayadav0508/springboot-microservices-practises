package com.Springboot_restServices_PUT_DELETE_Request.controller;

import com.Springboot_restServices_PUT_DELETE_Request.binding.Customer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/custom")
@Tag(name = "Customer API", description = "APIs for Customer Management")
public class CustomRestController {

    // Simulating a database
    private Map<Integer, Customer> customerDB = new HashMap<>();

    // ============== PUT - Full Update ==============
    @Operation(summary = "Update customer (Full)", description = "Replaces entire customer data - all fields required")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer updated successfully"),
            @ApiResponse(responseCode = "404", description = "Customer not found")
    })
    @PutMapping(value = "/update/{customerId}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Customer> updateCustomer(
            @RequestBody Customer customer,
            @Parameter(description = "Customer ID to update") @PathVariable Integer customerId) {

        System.out.println("PUT - Full Update: " + customer);
        customer.setCid(customerId);
        customerDB.put(customerId, customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    // ============== PATCH - Partial Update ==============
    @Operation(summary = "Update customer (Partial)", description = "Updates only provided fields - other fields remain unchanged")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer patched successfully"),
            @ApiResponse(responseCode = "404", description = "Customer not found")
    })
    @PatchMapping(value = "/update/{customerId}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Customer> patchCustomer(
            @RequestBody Map<String, Object> updates,
            @Parameter(description = "Customer ID to patch") @PathVariable Integer customerId) {

        System.out.println("PATCH - Partial Update for ID: " + customerId);

        Customer existing = customerDB.get(customerId);
        if (existing == null) {
            existing = new Customer();
            existing.setCid(customerId);
        }

        if (updates.containsKey("cname")) {
            existing.setCname((String) updates.get("cname"));
        }
        if (updates.containsKey("cemail")) {
            existing.setCemail((String) updates.get("cemail"));
        }

        customerDB.put(customerId, existing);
        return new ResponseEntity<>(existing, HttpStatus.OK);
    }

    // ============== DELETE ==============
    @Operation(summary = "Delete customer", description = "Removes a customer by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Customer not found")
    })
    @DeleteMapping(value = "/delete/{customerId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<String> deleteCustomer(
            @Parameter(description = "Customer ID to delete") @PathVariable Integer customerId) {

        System.out.println("DELETE - Customer ID: " + customerId);
        if (customerDB.containsKey(customerId)) {
            customerDB.remove(customerId);
            return new ResponseEntity<>("Customer deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
    }

    // ============== GET - Get All Customers ==============
    @Operation(summary = "Get all customers", description = "Retrieves all customers from the system")
    @GetMapping(value = "/all",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Map<Integer, Customer>> getAllCustomers() {
        return new ResponseEntity<>(customerDB, HttpStatus.OK);
    }

    // ============== POST - Create Customer ==============
    @Operation(summary = "Create customer", description = "Creates a new customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer created successfully")
    })
    @PostMapping(value = "/create",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        System.out.println("POST - Create Customer: " + customer);
        customerDB.put(customer.getCid(), customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }
}
