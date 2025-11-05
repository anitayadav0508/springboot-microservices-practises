package com.springboot.webmvc.passing.data.by.differentway.from.UI.to.Server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {
    @RequestMapping("/book")
    @ResponseBody
    public String getBookPrice(@RequestParam(name = "isbn", required = false, defaultValue = "ISBN002") String isbn) {
        String msg = "The book Price of " + isbn + " Is : 450.00 INR";
        return msg;
    }
}
