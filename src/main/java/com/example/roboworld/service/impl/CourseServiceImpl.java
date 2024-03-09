package com.example.roboworld.service.impl;

import com.example.roboworld.model.dto.CourseViewDto;
import com.example.roboworld.model.entity.Course;
import com.example.roboworld.model.entity.User;
import com.example.roboworld.model.entity.enums.AgeLimit;
import com.example.roboworld.repository.CourseRepository;
import com.example.roboworld.repository.UserRepository;
import com.example.roboworld.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    private final ModelMapper modelMapper;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public CourseServiceImpl(ModelMapper modelMapper, CourseRepository courseRepository, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<CourseViewDto> getAllByAgeLimit(AgeLimit ageLimit) {
        return courseRepository.findAllByAgeLimit(ageLimit).
        stream().map(course -> modelMapper.map(course, CourseViewDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public CourseViewDto findById(Long id) {

        return modelMapper.map(courseRepository.findById(id).orElseThrow(), CourseViewDto.class);
    }

    @Override
    public List<CourseViewDto> getAllWithoutThis(Long id, Pageable pageable) {
       return courseRepository.findAll(pageable).stream().filter(course -> course.getId() != id)
                .map(course -> modelMapper.map(course, CourseViewDto.class))
               .collect(Collectors.toList());
    }

    @Override
    public void signInUp(Long id, UserDetails userDetails) {
        User user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow();
        Course course = courseRepository.findById(id).orElseThrow();
        if (!user.getCourses().contains(course)) {
            user.getSignInCourses().add(course);
        }
        userRepository.save(user);
    }

    @Override
    public List<CourseViewDto> getAllSignInCourses() {
       return courseRepository.findAll().stream().filter(course -> course.getStudents().size() > 0)
                .map(course -> modelMapper.map(course, CourseViewDto.class))
                .collect(Collectors.toList());
    }

}
