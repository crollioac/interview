package com.interview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class InterviewVideoApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(InterviewVideoApplication.class, args);
	}
}
