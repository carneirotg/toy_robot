package com.code.boundary.service.robot.service;

import com.code.boundary.service.robot.entities.Action;
import com.code.boundary.service.robot.entities.Robot;

public interface RobotService {
	
	public void doAction(Robot robot, Action action);

}
