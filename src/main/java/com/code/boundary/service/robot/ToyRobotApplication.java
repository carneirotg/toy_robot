package com.code.boundary.service.robot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import com.code.boundary.service.robot.entities.Action;
import com.code.boundary.service.robot.entities.Robot;
import com.code.boundary.service.robot.repository.RobotRepository;

@SpringBootApplication
public class ToyRobotApplication implements CommandLineRunner {

	@Autowired
	private RobotRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(ToyRobotApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {

		repo.deleteAll();
		
		System.out.println("Starting...");
		repo.save(new Robot(0,0,"NORTH"));
		repo.save(new Robot(0,0,"SOUTH"));
		repo.save(new Robot(0,0,"EAST"));
		repo.save(new Robot(0,0,"WEST"));
		
		System.out.println("Robot gravado no banco");
		
		List<Robot> robots = repo.findAll();
		for (Robot robot : robots) {
			System.out.println(robot.toString());
		}
		
		Robot robot = repo.findAll(Sort.by(new Order(Direction.DESC, "id"))).get(0);
		System.out.println("O ultimo robo adicionado e:");
		System.out.println(robot.toString());
		
		robot.setX(1);
		robot.setLastStep(Action.MOVE.toString());
		repo.save(robot);
		
		Robot robot1 = repo.findById(robot.getId()).get();
		System.out.println("Robot atualizado com a coordenada x:");
		System.out.println(robot1);
		
		
	}
}
