package com.code.boundary.robot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.code.boundary.robot.repository.RobotRepository;

@SpringBootApplication
@ImportResource("classpath:toy-robot-beans.xml")
public class ToyRobotApplication implements CommandLineRunner{

	@Autowired
	private RobotRepository robotRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ToyRobotApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		robotRepository.deleteAll();
		
	}
}
