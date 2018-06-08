package com.code.boundary.robot.service;

import com.code.boundary.robot.entities.Action;
import com.code.boundary.robot.entities.Output;
import com.code.boundary.robot.entities.Robot;
import com.code.boundary.robot.rest.MissingRobotException;

public interface RobotService {
	
	public void createRobot(Robot robot);
	
	public void doAction(Action action, Robot robot);
	
	public Output getOutput() throws MissingRobotException;

}
