package com.practise.springboot_1.utils;

public class DateUtil {
    public DateUtil(){
        System.out.println("-------------- DateUtil class ,Package Scanning participate in component scanning " +
                "but class is not spring bean class due to not present @Component annotation not present but we create" +
                "customized object our own and tell ioc container to call method on which @Bean annotation");
    }
}
