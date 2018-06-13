package com.code.boundary.robot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.boundary.robot.entities.Action;
import com.code.boundary.robot.entities.Orientation;
import com.code.boundary.robot.entities.Output;
import com.code.boundary.robot.entities.Robot;
import com.code.boundary.robot.repository.RobotRepository;
import com.code.boundary.robot.rest.MissingRobotException;

@Service
public class RobotServiceImpl implements RobotService{

	@Autowired
	private RobotRepository robotRepository;
	
	@Override
	public void doAction(Action action, Robot robot) {
		
		switch (action) {
		case MOVE:
			doMovement(robot);
			robotRepository.save(robot);
			break;
		case LEFT:
			updateRobot(robot, robot.getOrientation().previous());
			break;
		case RIGHT:
			updateRobot(robot, robot.getOrientation().next());
			break;
		default:
			break;
		}
		
	}

	private void doMovement(Robot robot) {
		
		switch (robot.getOrientation()) {
		case NORTH:
			int yNorth = robot.getY() + 1 > 5 ? robot.getY() : robot.getY() + 1;
			robot.setY(yNorth);
			break;
		case EAST:
			int xEast = robot.getX() + 1 > 5 ? robot.getX() : robot.getX() + 1;
			robot.setX(xEast);
			break;
		case SOUTH:
			int ySouth = robot.getY() - 1 < 0 ? robot.getY() : robot.getY() - 1;
			robot.setY(ySouth);
			break;
		case WEST:
			int xWest = robot.getX() - 1 < 0 ? robot.getX() : robot.getX() - 1;
			robot.setX(xWest);
			break;
		default:
			break;
		}
	}

	private void updateRobot(Robot robot, Orientation previous) {
		robot.setOrientation(previous);
		robot.setLastStep(Action.MOVE);
		robotRepository.save(robot);
	}

	@Override
	public void createRobot(Robot robot) {
		robotRepository.save(robot);
	}

	@Override
	public Output getOutput() throws MissingRobotException {
		
		Robot robot = robotRepository.findLastInserted();
		Output output = new Output();
		if (robot != null){
			output.setMessage(robot.toOutput());
			robot.setLastStep(Action.OUTPUT);
			robotRepository.save(robot);
		} else {
			throw new MissingRobotException("ROBOT MISSING");
		}
		
		return output;
	}

}
