package com.code.boundary.robot.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RobotRepositoryConfig {

	@Bean
	public RobotRepositoryCustomImpl robotRepository(){
		RobotRepositoryCustomImpl robotRepository = new RobotRepositoryCustomImpl();
		return robotRepository;
	}
}
