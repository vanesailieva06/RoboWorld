package com.example.roboworld.service;

import com.example.roboworld.model.dto.CourseViewDto;
import com.example.roboworld.model.entity.enums.AgeLimit;

import java.util.List;

public interface CourseService {
    List<CourseViewDto> getAllByAgeLimit(AgeLimit ageLimit);

}
