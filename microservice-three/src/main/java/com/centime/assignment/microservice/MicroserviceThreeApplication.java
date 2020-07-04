package com.centime.assignment.microservice;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MicroserviceThreeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceThreeApplication.class, args);
	}

	@Bean
	public Sampler defaultSample(){
		return Sampler.ALWAYS_SAMPLE;
	}
}
