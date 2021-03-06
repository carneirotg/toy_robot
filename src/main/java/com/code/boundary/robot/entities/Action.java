package com.code.boundary.robot.entities;

public enum Action {
	MOVE("MOVE"),
	LEFT("LEFT"),
	RIGHT("RIGHT"),
	OUTPUT("OUTPUT");
	
	private String content;
	
	Action(String content){
		this.content = content;
	}
	
	public String toString(){
		return content;
	}
}
