package com.example.roboworld.repository;

import com.example.roboworld.model.entity.Robot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RobotRepository extends JpaRepository<Robot, Long> {
}
