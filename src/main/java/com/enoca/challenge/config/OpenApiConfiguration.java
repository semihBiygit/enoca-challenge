package com.enoca.challenge.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Enoca API")
                        .version("1.0")
                        .description("""
                                This is an API that provides CRUD operations 
                                for employee and company
                                """
                        ));
    }

}
