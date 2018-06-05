package com.code.boundary.robot.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.code.boundary.robot.entities.Action;
import com.code.boundary.robot.entities.Output;
import com.code.boundary.robot.entities.Robot;
import com.code.boundary.robot.repository.RobotRepository;

public class RobotServiceImpl implements RobotService{

	@Autowired
	private RobotRepository robotRepository;
	
	@Override
	public void doAction(Robot robot, Action action) {
		
		
		
	}

	@Override
	public void createRobot(Robot robot) {
		robotRepository.save(robot);
	}

	@Override
	public Output getOutput() {
		
		Robot robot = robotRepository.findLastInserted();
		Output output = new Output();
		if (robot != null){
			output.setMessage(robot.toOutput());
		} else {
			output.setMessage("ROBOT MISSING");
		}
		return output;
	}

}
