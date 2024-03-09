package com.example.roboworld.service.impl;

import com.example.roboworld.model.dto.CourseViewDto;
import com.example.roboworld.model.entity.enums.AgeLimit;
import com.example.roboworld.repository.CourseRepository;
import com.example.roboworld.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    private final ModelMapper modelMapper;
    private final CourseRepository courseRepository;

    public CourseServiceImpl(ModelMapper modelMapper, CourseRepository courseRepository) {
        this.modelMapper = modelMapper;
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseViewDto> getAllByAgeLimit(AgeLimit ageLimit) {
        return courseRepository.findAllByAgeLimit(ageLimit).
        stream().map(course -> modelMapper.map(course, CourseViewDto.class))
                .collect(Collectors.toList());

    }

}
