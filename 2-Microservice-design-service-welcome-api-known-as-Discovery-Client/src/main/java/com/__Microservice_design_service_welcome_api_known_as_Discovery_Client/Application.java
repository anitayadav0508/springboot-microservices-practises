package com.__Microservice_design_service_welcome_api_known_as_Discovery_Client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient

/**To Represent this application as client for service registry we use @EnableDiscoveryClient annotation 
 * @EnableDiscoveryClient annotation is used to register this application with the service registry.
 * It is a Spring Cloud annotation that is used to register the application with the service registry.
   */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
