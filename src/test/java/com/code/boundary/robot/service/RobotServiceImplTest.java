package com.code.boundary.robot.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.code.boundary.robot.entities.Action;
import com.code.boundary.robot.entities.Orientation;
import com.code.boundary.robot.entities.Output;
import com.code.boundary.robot.entities.Robot;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:toy-robot-beans-test.xml")
public class RobotServiceImplTest {

	@Autowired
	private RobotService robotService;
	
	@Test
	public void testMovementMove(){
		
		Robot robot = new Robot();
		robot.setX(2);
		robot.setY(4);
		robot.setOrientation(Orientation.SOUTH);
		
		robotService.doAction(Action.MOVE, robot);
		assertEquals(2, robot.getX());
		assertEquals(3, robot.getY());
		
	}
	
	@Test
	public void testMovementLeft(){
		
		Robot robot = new Robot();
		robot.setX(2);
		robot.setY(4);
		robot.setOrientation(Orientation.SOUTH);
		
		robotService.doAction(Action.LEFT, robot);
		assertEquals(Orientation.EAST, robot.getOrientation());
		
	}
	
	@Test
	public void testMovementRight(){
		
		Robot robot = new Robot();
		robot.setX(2);
		robot.setY(4);
		robot.setOrientation(Orientation.SOUTH);
		
		robotService.doAction(Action.RIGHT, robot);
		assertEquals(Orientation.WEST, robot.getOrientation());
		
	}
	
	@Test
	public void testUpperEdgesOfTable(){
		
		Robot robot = new Robot();
		robot.setX(5);
		robot.setY(5);
		robot.setOrientation(Orientation.NORTH);
		
		robotService.doAction(Action.MOVE, robot);
		assertEquals(5, robot.getY());
		
		robotService.doAction(Action.RIGHT, robot);
		robotService.doAction(Action.MOVE, robot);
		assertEquals(5, robot.getX());
		
	}
	
	@Test
	public void testLowerEdgesOfTable(){
		
		Robot robot = new Robot();
		robot.setX(0);
		robot.setY(0);
		robot.setOrientation(Orientation.SOUTH);
		
		robotService.doAction(Action.MOVE, robot);
		assertEquals(0, robot.getY());
		
		robotService.doAction(Action.RIGHT, robot);
		robotService.doAction(Action.MOVE, robot);
		assertEquals(Orientation.WEST, robot.getOrientation());
		assertEquals(0, robot.getX());
		
	}
	
	@Test
	public void moveWithSuccessAndGetOutput(){
		
		Robot robot = new Robot();
		robot.setX(1);
		robot.setY(3);
		robot.setOrientation(Orientation.NORTH);
		
		robotService.doAction(Action.MOVE, robot);
		assertEquals(4, robot.getY());
		
		robotService.doAction(Action.RIGHT, robot);
		robotService.doAction(Action.MOVE, robot);
		assertEquals(2, robot.getX());
		assertEquals(Orientation.EAST, robot.getOrientation());
		
		robotService.doAction(Action.LEFT, robot);
		robotService.doAction(Action.MOVE, robot);
		assertEquals(Orientation.NORTH, robot.getOrientation());
		assertEquals(2, robot.getX());
		assertEquals(5, robot.getY());
		
		Output expected = new Output();
		expected.setMessage("Output: 2, 5, NORTH");
		
		assertEquals(expected.getMessage(), robot.toOutput());
		
	}
	
	
}
