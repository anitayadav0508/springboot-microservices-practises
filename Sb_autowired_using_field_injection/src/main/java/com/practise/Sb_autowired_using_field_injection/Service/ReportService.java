package com.practise.Sb_autowired_using_field_injection.Service;

import com.practise.Sb_autowired_using_field_injection.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReportService {

    ReportService(){
        System.out.println("----------Repersent ReportService as spring bean using @Service annotation" +
                "Ioc container create object for this bean using 0-params constructor------------");
    }
    @Autowired
    //using field injection for DI(dependency injection by IOC container) here Ioc container not using constructor(1-param-constructor
    // which take DateUtil as a paramerter)/setter method to inject dependent
//    object into the target bean it using reflection Api for performing field injection
    //Reflection api how internally work see code into MyApp.java , IOC container use that type of code(Mention in MyApp.java) for field injection using
    // reflection api
    private DateUtil du;


    public void generateReport(){
      LocalDate date =   du.getDate();
        System.out.println("  Report generated on date  " + date + " successfully ");
    }
}
