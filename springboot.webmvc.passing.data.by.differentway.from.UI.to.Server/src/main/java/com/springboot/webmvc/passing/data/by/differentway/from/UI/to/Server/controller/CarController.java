package com.springboot.webmvc.passing.data.by.differentway.from.UI.to.Server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CarController {
    @GetMapping("/price/{carName}")
    @ResponseBody
    public String getCarPrice(@PathVariable("carName") String carName){
        return carName + " Price is 7.8 lakhs";
    }

    @GetMapping("/check/{carName}/{location}/{branch}/car")
    @ResponseBody
    public String checkCar(@PathVariable String carName,@PathVariable
    String location,@PathVariable String branch ){
        return carName + " " + "available at" + " " + location + " "+ "from branch" + branch;
    }
}
