package com.code.boundary.robot.rest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.io.IOException;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.code.boundary.robot.entities.Action;
import com.code.boundary.robot.entities.Movement;
import com.code.boundary.robot.entities.Orientation;
import com.code.boundary.robot.entities.Output;
import com.code.boundary.robot.entities.Robot;
import com.code.boundary.robot.repository.RobotRepository;
import com.code.boundary.robot.util.TestUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(RobotController.class)
@ContextConfiguration(locations="classpath:toy-robot-beans-test.xml")
public class RobotControllerTest {

	 @Autowired
	 private MockMvc mvc;

	 @Autowired
	 private RobotRepository robotRepository;

	 @Autowired
	 @InjectMocks
	 private RobotController robotController;

	 @Before
	 public void setUp(){
		 robotRepository.deleteAll();
	 }

	 @Test
	 public void post_CreateRobotWithInvalidX_ExceptionThrown() throws IOException, Exception{
		 Robot robot = new Robot();
		 robot.setX(6);
		 robot.setY(0);
		 robot.setOrientation(Orientation.EAST);

		 this.mvc.perform(post("/robot/")
				 .contentType(MediaType.APPLICATION_JSON)
				 .accept(MediaType.APPLICATION_JSON)
				 .content(TestUtil.convertObjectToJsonBytes(robot)))
		 		 .andExpect(MockMvcResultMatchers.status().isBadRequest());
	 }

	 @Test
	 public void post_CreateRobotWithInvalidY_ExceptionThrown() throws IOException, Exception{
		 Robot robot = new Robot();
		 robot.setX(2);
		 robot.setY(6);
		 robot.setOrientation(Orientation.EAST);

		 this.mvc.perform(post("/robot/")
				 .contentType(MediaType.APPLICATION_JSON)
				 .accept(MediaType.APPLICATION_JSON)
				 .content(TestUtil.convertObjectToJsonBytes(robot)))
		 		 .andExpect(MockMvcResultMatchers.status().isBadRequest());
	 }

	 @Test
	 public void get_reportWithoutAnyPreviousRobot_RobotMissing() throws Exception{

		 when(robotRepository.findLastInserted()).thenReturn(null);
		 assertEquals(null, robotRepository.findLastInserted());

         this.mvc.perform(get("/robot/report")
                 .accept(MediaType.APPLICATION_JSON))
                 .andExpect(MockMvcResultMatchers.status().isNotFound());

	 }

	 @Test
	 public void post_createRobotWithSuccess() throws Exception{

		 Robot robot = new Robot();
		 robot.setX(0);
		 robot.setY(0);
		 robot.setOrientation(Orientation.EAST);

		 this.mvc.perform(post("/robot/")
				 .contentType(MediaType.APPLICATION_JSON)
				 .accept(MediaType.APPLICATION_JSON)
				 .content(TestUtil.convertObjectToJsonBytes(robot)))
		 		 .andExpect(MockMvcResultMatchers.status().isCreated());
	 }

	 @Test
	 public void post_createRobotWithInvalidOrientation_ExceptionThrown() throws Exception{

		 String content = "{\"x\": 0,\"y\": 0,\"orientation\": \"UP\"}";

		 this.mvc.perform(post("/robot/")
				 .contentType(MediaType.APPLICATION_JSON)
				 .accept(MediaType.APPLICATION_JSON)
				 .content(content))
		 		 .andExpect(MockMvcResultMatchers.status().isBadRequest());
	 }

	 @Test
	 public void put_MovementBeforeCreatingRobot_RobotMissing() throws IOException, Exception{

		 Movement m = new Movement();
		 m.setAction(Action.MOVE);
		 
		 when(robotRepository.findLastInserted()).thenReturn(null);
		 assertEquals(null, robotRepository.findLastInserted());

		 this.mvc.perform(put("/robot/position")
				 .contentType(MediaType.APPLICATION_JSON)
				 .accept(MediaType.APPLICATION_JSON)
				 .content(TestUtil.convertObjectToJsonBytes(m)))
				 .andExpect(MockMvcResultMatchers.status().isNotFound());
	 }

	 @Test
	 public void put_movementWithSuccess() throws Exception{

		 //create robot
		 Robot robot = new Robot();
		 robot.setX(0);
		 robot.setY(0);
		 robot.setOrientation(Orientation.EAST);

		 Movement m = new Movement();
		 m.setAction(Action.MOVE);

		 when(robotRepository.findLastInserted()).thenReturn(robot);
		 assertEquals(robotRepository.findLastInserted(), robot);

		 this.mvc.perform(put("/robot/position")
				 .contentType(MediaType.APPLICATION_JSON)
				 .accept(MediaType.APPLICATION_JSON)
				 .content(TestUtil.convertObjectToJsonBytes(m)))
				 .andExpect(MockMvcResultMatchers.status().isNoContent());

	 }

	 @Test
	 public void get_reportWithSuccess() throws Exception{

		 Robot robot = new Robot();
		 robot.setX(1);
		 robot.setY(0);
		 robot.setOrientation(Orientation.SOUTH);

		 when(robotRepository.findLastInserted()).thenReturn(robot);
		 assertEquals(robotRepository.findLastInserted(), robot);

		 Output output = new Output();
		 output.setMessage("Output: 1, 0, SOUTH");

		 JSONObject expectedResponse = new JSONObject();
		 expectedResponse.put("message", "Output: 1, 0, SOUTH");

         this.mvc.perform(get("/robot/report")
                 .accept(MediaType.APPLICATION_JSON))
                 .andExpect(MockMvcResultMatchers.status().isOk())
                 .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(expectedResponse.get("message")));
	 }
}
