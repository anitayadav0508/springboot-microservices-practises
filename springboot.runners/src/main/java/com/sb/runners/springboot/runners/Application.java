package com.sb.runners.springboot.runners;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);

        //Java-8 approach to work with runner
        ApplicationRunner appRunner = (obj) ->{
            System.out.println("I am from app runner :: using lambda expression ");
        };
        appRunner.run(null);
	}

}
