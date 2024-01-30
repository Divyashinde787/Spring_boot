package com.techhub;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootWithSumit3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithSumit3Application.class, args);
		System.out.println("connect ........");
		
	}
	@Bean
	public ModelMapper mappermtd() {
		
		return new ModelMapper();
	}

	
	
}
