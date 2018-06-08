package com.code.boundary.robot.entities;

import java.util.EnumSet;

public enum Orientation {
	NORTH("NORTH"),
	EAST("EAST"),
	SOUTH("SOUTH"),
	WEST("WEST");
	
	private String content;
	private static Orientation[] compassList = values();
	
	Orientation(String content){
		this.content = content;
	}
	
	public Orientation next(){
		return compassList[(this.ordinal()+1) % compassList.length];
	}
	
	public Orientation previous(){
		int length = compassList.length;
		return compassList[(length - ((length - (this.ordinal() - 1)) % length)) % length];
	}
	
	public String toString(){
		return content;
	}
	
}
