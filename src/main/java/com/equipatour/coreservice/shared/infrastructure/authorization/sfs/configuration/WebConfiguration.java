package com.equipatour.coreservice.shared.infrastructure.authorization.sfs.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200", "https://equipatour-app.web.app/") // Allow your frontend domain
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD") // Specify allowed methods
                        .allowedHeaders("*") // Allow any headers
                        .allowCredentials(true); // Allow credentials
            }
        };
    }
}