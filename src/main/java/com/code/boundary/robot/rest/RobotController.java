package com.code.boundary.robot.rest;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.code.boundary.robot.entities.Action;
import com.code.boundary.robot.entities.Movement;
import com.code.boundary.robot.entities.Output;
import com.code.boundary.robot.entities.Robot;
import com.code.boundary.robot.repository.RobotRepository;
import com.code.boundary.robot.service.RobotService;

@RestController
@RequestMapping("/robot")
public class RobotController {
	
	private static final Logger logger = LogManager.getLogger(RobotController.class);
	
	@Autowired
	private RobotRepository robotRepository;

	@Autowired
	private RobotService robotService;
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public void create(@RequestBody Robot robot) throws InvalidValueException{
		logger.debug("Robot Created -> "+ robot);
		
		if (robot.getX() < 0 || robot.getX() > 5){
			throw new InvalidValueException("The X should be >= 0 and <= 5");
		} else if (robot.getY() < 0 || robot.getY() > 5){
			throw new InvalidValueException("The Y should be >= 0 and <= 5");
		}
		
		robotService.createRobot(robot);
		
	}
	
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	@RequestMapping(value = {"/position"}, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	public void update(@Valid @RequestBody Movement movement) throws MissingRobotException{
		
		Robot robot = robotRepository.findLastInserted();
		if (robot == null){
			throw new MissingRobotException("ROBOT MISSING");
		}
		
		if (robot.getLastStep() != null && robot.getLastStep().equals(Action.OUTPUT)){
			throw new MissingRobotException("ROBOT MISSING");
		}
		
		robotService.doAction(movement.getAction(), robot);
		logger.debug(robot);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = {"/report"}, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public Output getReport() throws MissingRobotException{
	
		Output output;
		try{
			output = robotService.getOutput();
		} catch(MissingRobotException ex){
			throw new MissingRobotException("ROBOT MISSING");
		}
		
		logger.debug("Output -> "+ output);
		return output;
	}
}
