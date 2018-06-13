package com.code.boundary.robot.base;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.code.boundary.robot.repository.RobotRepository;
import com.code.boundary.robot.service.RobotService;
import com.code.boundary.robot.service.RobotServiceImpl;

@Configuration
public class RobotConfig {

  	@Bean
  	public RobotService robotService(){
  		RobotService robotService = new RobotServiceImpl();
  		return robotService;
  	}
  	
  	@Bean
  	public RobotRepository robotRepository(){
  		return Mockito.mock(RobotRepository.class);
  	}
}
