package com.spring.boot.validation_mvc_project.controller;

import com.spring.boot.validation_mvc_project.binding.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/user-form")
    public String loadUserForm(Model model) {

        User useObj = new User();

        model.addAttribute("user", useObj);
        return "index";
    }

    @PostMapping("/saveUser")
    public String saveUser(@Valid User user, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return "index";
        }

        System.out.println("User: " + user);
        model.addAttribute("msg", "user saved sucessfully!!");
        return "dashboard";
    }
}
