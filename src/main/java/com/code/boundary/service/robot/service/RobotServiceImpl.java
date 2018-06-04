package com.code.boundary.service.robot.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.code.boundary.service.robot.entities.Action;
import com.code.boundary.service.robot.entities.Robot;
import com.code.boundary.service.robot.repository.RobotRepository;

public class RobotServiceImpl implements RobotService{

	@Autowired
	RobotRepository repo;
	
	@Override
	public void doAction(Robot robot, Action action) {
		
		
		
	}

}
