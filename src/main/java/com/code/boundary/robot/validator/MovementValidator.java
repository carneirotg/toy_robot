package com.code.boundary.robot.validator;

import com.code.boundary.robot.entities.Action;

public class MovementValidator {
	
	public boolean validateMovement(Action action){
		return action != null && action.toString() != null;
	}

}
