package com.springboot.compositekeyconcept.on.entity;

import com.springboot.compositekeyconcept.on.entity.service.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

       ConfigurableApplicationContext ctx  =SpringApplication.run(Application.class, args);
       OrderService orderService =ctx.getBean(OrderService.class);
       orderService.orderARecord();
	}

}
