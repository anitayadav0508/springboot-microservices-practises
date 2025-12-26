package com.mappings.onetomany.controller;

import com.mappings.onetomany.dto.OrderRequest;
import com.mappings.onetomany.dto.OrderResponse;
import com.mappings.onetomany.entity.Customer;
import com.mappings.onetomany.repository.CustomerRepository;
import com.mappings.onetomany.repository.ProductRepository;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody OrderRequest orderRequest){
       return customerRepository.save(orderRequest.getCustomer());
     }

     @GetMapping("/allOrders")
     public List<Customer> findAllOrders(){
        return customerRepository.findAll();
     }

     @GetMapping("/getInfo")
     public List<OrderResponse> getJoinInformation(){
        return customerRepository.getJoinInformation();
     }

}
