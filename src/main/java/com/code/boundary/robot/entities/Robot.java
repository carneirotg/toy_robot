package com.code.boundary.robot.entities;

import javax.validation.constraints.Max;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "robot")
public class Robot {

	@Id
	private String id;
	
	@Max(5)
	private int x;
	
	@Max(5)
	private int y;
	
	private Orientation orientation;
	
	private Action lastStep;
	
	
	public String getId() {
		return id;
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

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation east) {
		this.orientation = east;
	}

	public Action getLastStep() {
		return lastStep;
	}

	public void setLastStep(Action lastStep) {
		this.lastStep = lastStep;
	}

	public String toString(){
		return String.format("X: [%d], Y: [%d], Orientation: [%s], lastStep: [%s]", x,y,orientation, lastStep);
	}
	
	public String toOutput(){
		return String.format("Output: %d, %d, %s", x,y,orientation);
	}

}
