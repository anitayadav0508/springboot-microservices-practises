package com.springboot.web.spring.mvc.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

    @GetMapping
    public ModelAndView displayWelcomeMsg(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg","Welcome to spring webMvc Project");
        mav.setViewName("index");
        return mav;
    }
}
