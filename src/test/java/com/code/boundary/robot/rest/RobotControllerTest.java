package com.code.boundary.robot.rest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.code.boundary.robot.entities.Output;
import com.code.boundary.robot.service.RobotService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(RobotController.class)
@ContextConfiguration(classes = {RobotController.class})
public class RobotControllerTest {
	
	 @Autowired
	 private MockMvc mvc;
	 
//	 @Autowired
//	 private RobotService robotService;
	    
	 @MockBean
	 private RobotController robotController;
	 
	 @Test
	 public void testReportWithoutAnyPreviousRobot() throws Exception{
		 
//		 Output output = new Output();
//		 output.setMessage("ROBOT MISSING");
//		 
////		 when(robotService.getOutput()).thenReturn(output);
//		 
//		 JSONObject expectedResponse = new JSONObject();
//		 expectedResponse.put("message", "ROBOT MISSING");
//		 
//         this.mvc.perform(get("/robot/report")
//                 .accept(MediaType.APPLICATION_JSON))
//                 .andExpect(MockMvcResultMatchers.status().isOk())
//                 .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(expectedResponse.get("message")));
		 
	 }

	
	//testar criacao com sucesso
	//testar criacao robo parametro invalido
	//testar report sem nenhum robo criado
}
