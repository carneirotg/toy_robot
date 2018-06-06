package com.code.boundary.robot.entities;

public enum Orientation {
	NORTH("NORTH"),
	EAST("EAST"),
	WEST("WEST"),
	SOUTH("SOUTH");
	
	private String content;
	
	Orientation(String content){
		this.content = content;
	}
	
	public String toString(){
		return content;
	}
}
