package com.code.boundary.robot.rest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.json.JSONObject;
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

import com.code.boundary.robot.entities.Orientation;
import com.code.boundary.robot.entities.Output;
import com.code.boundary.robot.entities.Robot;
import com.code.boundary.robot.service.RobotService;
import com.code.boundary.robot.util.TestUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(RobotController.class)
@ContextConfiguration(locations="classpath:toy-robot-beans-test.xml")
public class RobotControllerTest {
	
	 @Autowired
	 private MockMvc mvc;
	 
	 @Autowired
	 private RobotService robotService;
	    
	 @Autowired
	 @InjectMocks
	 private RobotController robotController;
	 
	 @Test
	 public void testReportWithoutAnyPreviousRobot() throws Exception{
		 
		 Output output = new Output();
		 output.setMessage("ROBOT MISSING");
		 
		 when(robotService.getOutput()).thenReturn(output);
		 
		 JSONObject expectedResponse = new JSONObject();
		 expectedResponse.put("message", "ROBOT MISSING");
		 
         this.mvc.perform(get("/robot/report")
                 .accept(MediaType.APPLICATION_JSON))
                 .andExpect(MockMvcResultMatchers.status().isOk())
                 .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(expectedResponse.get("message")));
		 
	 }
	 
	 @Test
	 public void testCreateRobotSuccess() throws Exception{
		 
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
	 public void testCreateRobotWithInvalidOrientation() throws Exception{
		 
		 String content = "{\"x\": 0,\"y\": 0,\"orientation\": \"UP\"}";
		 
		 this.mvc.perform(post("/robot/")
				 .contentType(MediaType.APPLICATION_JSON)
				 .accept(MediaType.APPLICATION_JSON)
				 .content(content))
		 		 .andExpect(MockMvcResultMatchers.status().isBadRequest());
	 }

	
	//testar criacao com sucesso
	//testar criacao robo parametro invalido
	//testar report sem nenhum robo criado
}
