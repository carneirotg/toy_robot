package com.code.boundary.robot.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MissingRobotException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public MissingRobotException(String msg){
		super(msg);
	}

}
