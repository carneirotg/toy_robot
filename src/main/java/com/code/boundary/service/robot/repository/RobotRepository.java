package com.code.boundary.service.robot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.code.boundary.service.robot.entities.Robot;

public interface RobotRepository extends MongoRepository<Robot, String> {
	

}
