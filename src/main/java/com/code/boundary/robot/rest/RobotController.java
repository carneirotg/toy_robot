package com.code.boundary.robot.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.code.boundary.robot.entities.Movement;
import com.code.boundary.robot.entities.Output;
import com.code.boundary.robot.entities.Robot;
import com.code.boundary.robot.service.RobotService;
import com.code.boundary.robot.validator.RobotValidator;

@RestController
@RequestMapping("/robot")
public class RobotController {

	@Autowired
	private RobotService robotService;
	
	@Autowired
	private RobotValidator robotValidator;
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public void create(@Valid @RequestBody Robot robot){
		
		System.out.println(robot.getOrientation());
		robotService.createRobot(robot);
		
	}
	
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	@RequestMapping(value = {"/position"}, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	public void update(@RequestBody Movement action){
		
		
		
	}
	
	@RequestMapping(value = {"/report"}, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public Output getReport(){
		
		Output output = robotService.getOutput();
		System.out.println(output.getMessage());
		
		return output;
	}
}
