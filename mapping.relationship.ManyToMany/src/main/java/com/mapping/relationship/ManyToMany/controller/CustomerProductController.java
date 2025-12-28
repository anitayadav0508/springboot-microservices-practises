package com.mapping.relationship.ManyToMany.controller;


import com.mapping.relationship.ManyToMany.dto.CustomerResponse;
import com.mapping.relationship.ManyToMany.entity.Customer;
import com.mapping.relationship.ManyToMany.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerProductController {



    @Autowired

    private CustomerRepository customerRepository;
    @PostMapping("/saveProduct")
    public Customer savePurchaseProductByCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer);


    }

    @GetMapping("/product/list")
    public List<CustomerResponse> getAllCustomerListWithRespectiveTheirProducts(){

        return customerRepository.getAllProductPurchaseByCustomer();

    }

}
