package com.example.roboworld.repository;

import com.example.roboworld.model.entity.Course;
import com.example.roboworld.model.entity.enums.AgeLimit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findAllByAgeLimit(AgeLimit ageLimit);
}
