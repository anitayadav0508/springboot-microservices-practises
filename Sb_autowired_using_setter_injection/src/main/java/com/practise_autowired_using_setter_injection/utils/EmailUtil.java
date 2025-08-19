package com.practise_autowired_using_setter_injection.utils;

import org.springframework.stereotype.Component;

@Component
public class EmailUtil {

    EmailUtil(){
        System.out.println("---------Using 0-params constructor IOC create its object " +
                "Represent EmailUtil as spring bean due to @Component annotation ");
    }

    public void sendEmail(String email){
        System.out.println("Sending email succcessfully to email address" + email);
    }

}
