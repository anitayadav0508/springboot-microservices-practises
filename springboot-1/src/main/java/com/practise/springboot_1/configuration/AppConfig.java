package com.practise.springboot_1.configuration;

import com.practise.springboot_1.utils.DateUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
/*this annotation having first priority among all annotation*/
public class AppConfig {

    AppConfig(){
        System.out.println("----------------configuration class object has been created------------");
    }

    @Bean
    public DateUtil createDateUtil(){

        DateUtil dateUtil = new DateUtil();
        return dateUtil;
    }
}
