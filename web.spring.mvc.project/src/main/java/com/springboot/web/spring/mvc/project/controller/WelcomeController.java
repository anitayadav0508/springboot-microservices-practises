package com.springboot.web.spring.mvc.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller()
@RequestMapping("/welcome")
public class WelcomeController {

    @GetMapping("/display")
    public ModelAndView displayWelcomeMsg(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg","Implement how Spring mvc Works!!");
        mav.setViewName("index");
        return mav;
    }
}
