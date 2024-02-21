package com.esalon.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@OpenAPIDefinition
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() throws IOException {

        return new OpenAPI()
                .info(new Info()
                        .title("Mary E-Salon Management System")
                        .description("This is a simple E-salon management system")
                        .termsOfService("terms")
                        .contact(new Contact().email("mary@gmail.com"))
                        .license(new License().name("Mary"))
                        .version("v1.0")
                );
    }
}