package com.code.boundary.robot.repository;

import org.springframework.data.domain.Pageable;

import com.code.boundary.robot.entities.Robot;

public interface RobotRepositoryCustom {

	Robot findLastInserted();
}
