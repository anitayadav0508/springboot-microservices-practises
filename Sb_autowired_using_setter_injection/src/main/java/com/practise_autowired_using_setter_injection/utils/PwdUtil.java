package com.practise_autowired_using_setter_injection.utils;

import org.springframework.stereotype.Component;

@Component
public class PwdUtil {


    PwdUtil(){
        System.out.println("---------Using 0-params constructor IOC create its object " +
                "Represent PwdUtil as spring bean due to @Component annotation ");
    }

    public void  encryptPassword(String pwd){
        System.out.println("encrypted password" + pwd);
    }


}
