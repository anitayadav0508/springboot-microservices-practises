package com.springboot.webmvc.passing.data.by.differentway.from.UI.to.Server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CourseContoller {

    @GetMapping("/course")
    @ResponseBody
    public String getCourseDtls(String cname, String trainer){

        if(cname.equals("SBMS")){
            return cname + " By " + trainer + " starting by today";
        } else if(cname.equals("JQRT")){
            return cname + " By " + trainer + " starting by today";
        }

        return "contact by admin";
    }


}
