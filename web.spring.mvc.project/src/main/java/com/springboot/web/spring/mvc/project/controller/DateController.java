package com.springboot.web.spring.mvc.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Date;

@Controller()
@RequestMapping("/report")
public class DateController {

    @GetMapping("/date")
    public ModelAndView displayTodayDate(){
        ModelAndView mav = new ModelAndView();
        Date d = new Date();
        LocalDate ld = LocalDate.now();
        mav.addObject("msg","Today's date is " +ld);
        mav.setViewName("index");
        return mav;
    }
}
