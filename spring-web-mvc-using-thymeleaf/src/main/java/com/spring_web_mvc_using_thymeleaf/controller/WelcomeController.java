package com.spring_web_mvc_using_thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/welcome")
    public String displayMessage(Model model){
        model.addAttribute("msg","Welcome to my Thymleaf Project!!");
        return "index";

    }
}
