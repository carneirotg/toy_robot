package com.code.boundary.robot.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RobotServiceConfig {

	
	@Bean
	public RobotServiceImpl robotService(){
		RobotServiceImpl robotService = new RobotServiceImpl();
		return robotService;
	}
}
