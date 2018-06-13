package com.code.boundary.robot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import com.code.boundary.robot.repository.RobotRepository;

@SpringBootApplication
@ComponentScan
//@ImportResource("classpath:toy-robot-beans.xml")
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
