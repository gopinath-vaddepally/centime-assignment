package com.centime.assignment.microservice;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients("com.centime.assignment.microservice")
public class MicroserviceOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceOneApplication.class, args);
	}

	@Bean
	public Sampler defaultSample(){
		return Sampler.ALWAYS_SAMPLE;
	}
}
