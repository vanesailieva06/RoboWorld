package com.example.roboworld.service.impl;

import com.example.roboworld.model.dto.RobotAddDto;
import com.example.roboworld.model.dto.RobotViewDto;
import com.example.roboworld.model.entity.Robot;
import com.example.roboworld.model.entity.enums.Color;
import com.example.roboworld.model.entity.enums.Purpose;
import com.example.roboworld.repository.RobotRepository;
import com.example.roboworld.service.RobotService;
import com.example.roboworld.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class RobotServiceImpl implements RobotService {
    private final RobotRepository robotRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public RobotServiceImpl(RobotRepository robotRepository, UserService userService, ModelMapper modelMapper) {
        this.robotRepository = robotRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addRobot(RobotAddDto robotAddDto, UserDetails userDetails) {
        Robot robot = modelMapper.map(robotAddDto, Robot.class);
        robot.setColor(Color.valueOf(robotAddDto.getColor()));
        robot.setPurpose(Purpose.valueOf(robotAddDto.getPurpose()));
        robot.setUser(userService.findByUsername(userDetails.getUsername()));
        robot.setSpeaking(robotAddDto.getSpeaking().equals("Yes"));
        robotRepository.save(robot);
    }

    @Override
    public List<RobotViewDto> getAll() {
        return robotRepository.findAll()
                .stream().map(this::map)
                .collect(toList());
    }

    private RobotViewDto map(Robot robot) {
        RobotViewDto robotViewDto = modelMapper.map(robot, RobotViewDto.class);
        robotViewDto.setColor(robot.getColor().name().toLowerCase());
        robotViewDto.setPurpose(robot.getPurpose().name().toLowerCase());
        if (robot.getSpeaking()){
            robotViewDto.setSpeaking("This robot speaks");
        }else {
            robotViewDto.setSpeaking("This robot doesn't speak");
        }
        return robotViewDto;
    }


}
