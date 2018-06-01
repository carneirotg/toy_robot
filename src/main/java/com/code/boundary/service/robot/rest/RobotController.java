package com.code.boundary.service.robot.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/robot/")
public class RobotController {

	@ResponseStatus(value = HttpStatus.CREATED)
	 @RequestMapping(produces = "application/json", consumes = MediaType.TEXT_PLAIN_VALUE, method = RequestMethod.POST)
	public @ResponseBody String createAndMoveRobot(@RequestBody String body){
		
		return "OK";
	}
}
