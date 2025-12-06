package com.restapi.custom.response.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseRestController {


@GetMapping(value = "/course", produces = {"text/plain"})
    public String getCourseDetails(@RequestParam(value = "name",defaultValue = "SBMS") String name){
        String msg = "";

        if("SBMS".equals(name)){
           msg = "New Batch from SBMS from 15-Jul-2021 @8:00 PM IST";
        }else if("JRTP".equals(name)){
            msg = "New Batch from JRTP from 15-Jul-2021 @8:00 PM IST";
        }else{
            msg = "New Batch for AWS From tomorrow onwards";
        }

        return msg;
    }

    @GetMapping(value = "/fee",produces = {"text/plain"})
    public String getCourseFees(@RequestParam("cname")String cname,@RequestParam("tname") String tname){
      String msg = cname + "By" + tname + "is 5000 INR Only";
      return msg;
    }
}
