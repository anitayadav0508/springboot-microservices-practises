package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI irctcOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("IRCTC REST API")
                        .description("REST API for IRCTC Ticket Booking Application - Demonstrating HTTP Methods and Idempotency")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("IRCTC Support")
                                .email("support@irctc.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")));
    }
}
