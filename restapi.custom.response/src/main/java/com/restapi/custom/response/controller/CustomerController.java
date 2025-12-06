package com.restapi.custom.response.controller;

import com.restapi.custom.response.pojo.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    /*This method can produce result either json or xml format to client for xml response type you have to set
    * into headers accept - application/xml in postman of headers because by default it supported json only*/
    @GetMapping(value = "/customer",produces = {"application/json","application/xml"})
    public Customer getCustomerDetails(){
        Customer customer = new Customer();
        customer.setCustomerId(101);
        customer.setCustomerName("CustomerName");
        customer.setCustomerPhoneNo(12345678);
        return customer;
    }
}


