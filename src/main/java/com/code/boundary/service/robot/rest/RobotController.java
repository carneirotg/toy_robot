package com.code.boundary.service.robot.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.code.boundary.service.robot.entities.Movement;
import com.code.boundary.service.robot.entities.Robot;

@Controller
@RequestMapping("/robot")
public class RobotController {

	@ResponseStatus(value = HttpStatus.CREATED)
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public void create(@RequestBody Robot robot){
		System.out.println(robot.toString());
		
	}
	
	@ResponseStatus(value=HttpStatus.OK)
	@RequestMapping(value = {"/position"}, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	public void update(@RequestBody Movement action){
		
		
		
	}
	
	@ResponseStatus(value=HttpStatus.OK)
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public String get(){
		
		return "0,0,NORTH";
	}
}
