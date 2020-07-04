package com.centime.assignment.tasktwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = " com.centime")
@SpringBootApplication
public class TaskTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskTwoApplication.class, args);
	}

}
