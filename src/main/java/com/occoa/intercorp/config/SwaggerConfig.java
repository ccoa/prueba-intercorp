package com.occoa.intercorp.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
    @Bean
    public Docket api() {
    	
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.occoa.intercorp.controller"))              
          .paths(PathSelectors.ant("/*"))                          
          .build()
          .apiInfo(apiInfo());                                           
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfo(
          "Reto Intercorp", 
          "Solucion a la prueba de Intercorp para postular a la vacante de Backend Developer", 
          "1.0", 
          "Ninguno", 
          new Contact("Omar Ccoa Heredia", "omarccoa.com", "omarccoah@gmail.com"), 
          "License of API", "API license URL", Collections.emptyList());
    }
}
