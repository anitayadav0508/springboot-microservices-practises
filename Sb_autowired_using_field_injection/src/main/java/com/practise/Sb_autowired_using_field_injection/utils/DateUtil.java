package com.practise.Sb_autowired_using_field_injection.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DateUtil {
    DateUtil(){
        System.out.println("----------Repersent DateUtil as spring bean using @Component annotation" +
                "Ioc container create object for this bean using 0-params constructor------------");
    }

    public LocalDate  getDate(){
        LocalDate date = LocalDate.now();
        return date;
    }
}
