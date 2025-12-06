package com.restapi.custom.response.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/params")
public class PathParamsController {

    @GetMapping("/course/{cname}/trainer/{tname}")
    public String getCourseDetails(@PathVariable String cname, @PathVariable String tname){

        return cname + " teaches by " + tname + " by tomorrow by 8 p.m";
    }
}
