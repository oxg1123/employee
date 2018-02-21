package com.oxg.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.oxg.*"})
@EnableJpaRepositories(basePackages = "com.oxg.repository")
@EntityScan("com.oxg.data")
public class EmployeeApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}
}
