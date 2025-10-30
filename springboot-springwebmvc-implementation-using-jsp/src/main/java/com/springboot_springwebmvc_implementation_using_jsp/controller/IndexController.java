package com.springboot_springwebmvc_implementation_using_jsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {


    @GetMapping()
    public String index(){ //it having url pattern localhost:9091
        return "index";
    }

}
