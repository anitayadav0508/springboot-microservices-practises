package com.practise.SB_Autowired_Concept_1;

import com.practise.SB_Autowired_Concept_1.UserService.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SbAutowiredConcept1Application {

	public static void main(String[] args) {
	ConfigurableApplicationContext ctx =  SpringApplication.run(SbAutowiredConcept1Application.class, args);

        UserService userService = ctx.getBean(UserService.class);

          userService.getRegisterUser();
    }

}
