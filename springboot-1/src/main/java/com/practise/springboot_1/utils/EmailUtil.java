package com.practise.springboot_1.utils;

import org.springframework.stereotype.Component;

@Component
public class EmailUtil {
    EmailUtil(){
        System.out.println("-----------------Email util participate in component scanning" + "  1. package in which Emailutil class it is subpackage of base package so package participate in component scanning"
                +"   2. using annotation @Component  Represent this java class as spring  bean class----------------");
    }
}
