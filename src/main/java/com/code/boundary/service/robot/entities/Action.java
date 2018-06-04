package com.code.boundary.service.robot.entities;

public enum Action {
	MOVE("MOVE"),
	LEFT("LEFT"),
	RIGHT("RIGHT");
	
	private String content;
	
	Action(String content){
		this.content = content;
	}
	
	public String toString(){
		return content;
	}
}
