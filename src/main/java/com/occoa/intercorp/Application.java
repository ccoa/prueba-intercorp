package com.occoa.intercorp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableJpaRepositories(basePackages = "com.occoa.intercorp.dao")
@EntityScan(basePackages = "com.occoa.intercorp.model")
public class Application {
	
    public static void main( String[] args ) {
    	
    	SpringApplication.run(Application.class, args);
    }
}
