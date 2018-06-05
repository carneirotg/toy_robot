package com.code.boundary.robot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.code.boundary.robot.entities.Robot;

public interface RobotRepository extends MongoRepository<Robot, String>, RobotRepositoryCustom {
	
	
	

}
