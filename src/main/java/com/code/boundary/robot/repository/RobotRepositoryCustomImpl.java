package com.code.boundary.robot.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import com.code.boundary.robot.entities.Robot;

public class RobotRepositoryCustomImpl implements RobotRepositoryCustom{

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public Robot findLastInserted() {
		Pageable request = PageRequest.of(0, 1, Sort.by(Direction.DESC, "id"));
		Query query = new Query();
		query.with(request);
		
		List<Robot> robots = mongoTemplate.find(query, Robot.class);
		if (robots.isEmpty()){
			return null;
		}
		System.out.println(robots);
		Robot robot = robots.get(0);
		
		robot.setLastStep("OUTPUT");
		mongoTemplate.save(robot);
		
		return robot;
	}

}
