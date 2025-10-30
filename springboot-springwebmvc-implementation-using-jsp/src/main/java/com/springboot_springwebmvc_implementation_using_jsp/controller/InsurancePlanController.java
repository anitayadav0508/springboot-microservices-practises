package com.springboot_springwebmvc_implementation_using_jsp.controller;

import com.springboot_springwebmvc_implementation_using_jsp.pojo.Insurance;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InsurancePlanController {

    @GetMapping("/insurancePlan")
    @ResponseBody
    public Insurance displayInsurancePlanDetails(){
        Insurance insurance = new Insurance();
        insurance.setPlanStatus("Approved");
        insurance.setPlanName("LIC");
        insurance.setPlanId(101);

        return insurance;
    }
}
