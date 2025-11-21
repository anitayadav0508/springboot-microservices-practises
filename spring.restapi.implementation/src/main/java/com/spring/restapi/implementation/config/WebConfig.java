package com.spring.restapi.implementation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer
                .favorParameter(false)  // Don't use URL parameter for content negotiation
                .favorPathExtension(false)  // Don't use file extension for content negotiation
                .ignoreAcceptHeader(false)  // Use Accept header for content negotiation
                .defaultContentType(MediaType.APPLICATION_JSON)  // Default to JSON
                .mediaType("json", MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML);
    }
}

