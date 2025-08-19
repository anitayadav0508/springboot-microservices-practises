package com.practise_autowired_using_setter_injection;

import com.practise_autowired_using_setter_injection.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SetterInjectionApplication {

	public static void main(String[] args) {
	 ConfigurableApplicationContext ctx =  SpringApplication.run(SetterInjectionApplication.class, args);
    UserService userService = ctx.getBean(UserService.class);
     userService.registerUser();
	}

}
