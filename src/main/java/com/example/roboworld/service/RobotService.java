package com.example.roboworld.service;

import com.example.roboworld.model.dto.RobotAddDto;
import com.example.roboworld.model.dto.RobotViewDto;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface RobotService {
    void addRobot(RobotAddDto robotAddDto, UserDetails userDetails);

    List<RobotViewDto> getAll();
}
