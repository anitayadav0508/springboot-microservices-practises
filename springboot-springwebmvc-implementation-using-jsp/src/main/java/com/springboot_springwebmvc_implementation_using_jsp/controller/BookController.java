package com.springboot_springwebmvc_implementation_using_jsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class BookController {


    @GetMapping("/book")
    public String displayBookData(Model model){
        model.addAttribute("bookname","Expert in Java!!");
        model.addAttribute("author","Johnson");
        model.addAttribute("published","19-08-2025");
        return "book-data";
    }
}
