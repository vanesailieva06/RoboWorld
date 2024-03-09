package com.example.roboworld.service;

import com.example.roboworld.model.dto.CourseViewDto;
import com.example.roboworld.model.entity.enums.AgeLimit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface CourseService {
    List<CourseViewDto> getAllByAgeLimit(AgeLimit ageLimit);


    CourseViewDto findById(Long id);

    List<CourseViewDto> getAllWithoutThis(Long id, Pageable pageable);

    void signInUp(Long id, UserDetails userDetails);

    List<CourseViewDto> getAllSignInCourses();
}
