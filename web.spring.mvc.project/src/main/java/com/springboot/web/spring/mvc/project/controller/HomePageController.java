package com.springboot.web.spring.mvc.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/login")
public class HomePageController {

    @GetMapping("/dashboard")
    public String homePage(Model model){
        model.addAttribute("msg","Welcome to dashboard/Home Page");
        return "index";

    }
}
