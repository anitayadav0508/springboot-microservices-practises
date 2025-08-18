package com.practise.springboot_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Springboot1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx  =SpringApplication.run(Springboot1Application.class, args);
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        System.out.println("----------------------------------------Beans are ------------------------------------------------");
        for(String bean: beanDefinitionNames){

//            System.out.println(bean);
        }



    }

}
