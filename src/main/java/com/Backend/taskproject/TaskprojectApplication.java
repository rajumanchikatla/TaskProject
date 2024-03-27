package com.Backend.taskproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskprojectApplication {
	
	private static Logger LOGGER = LoggerFactory.getLogger(TaskprojectApplication.class);

	public static void main(String[] args) {
		
		LOGGER.info("starting TaskProjectApplication");
		SpringApplication.run(TaskprojectApplication.class, args);
	}

}
