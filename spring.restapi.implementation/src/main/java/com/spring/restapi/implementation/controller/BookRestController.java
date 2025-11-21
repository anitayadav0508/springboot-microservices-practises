package com.spring.restapi.implementation.controller;

import com.spring.restapi.implementation.pojo.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookRestController {

    @GetMapping("/book")
    public Book getBookData(){
       return  new Book(101,"The Complete Refernce",255.50);

    }
}
