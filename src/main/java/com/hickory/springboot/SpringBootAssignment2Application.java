package com.hickory.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.hickory.springboot")
public class SpringBootAssignment2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAssignment2Application.class, args);
	}

}
