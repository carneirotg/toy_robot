package com.code.boundary.service.robot.entities;

import org.springframework.data.annotation.Id;

public class Robot {

	@Id
	private String id;
	
	private int x;
	
	private int y;
	
	private String orientation;
	
	private String lastStep;
	
	public Robot(int x, int y, String orientation){
		this.x = x;
		this.y = y;
		this.orientation = orientation;
	}

	public String getLastStep() {
		return lastStep;
	}

	public void setLastStep(String lastStep) {
		this.lastStep = lastStep;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}
	
	public String toString(){
		return String.format("id: [%s], X: [%d], Y: [%d], Orientation: [%s], lastStep: [%s]", id.toString(),x,y,orientation, lastStep);
	}

	public String getId() {
		return id.toString();
	}

}
