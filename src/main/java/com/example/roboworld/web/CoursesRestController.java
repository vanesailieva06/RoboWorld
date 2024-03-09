package com.example.roboworld.web;

import com.example.roboworld.model.dto.CourseViewDto;
import com.example.roboworld.model.entity.enums.AgeLimit;
import com.example.roboworld.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CoursesRestController {
    public final CourseService courseService;

    public CoursesRestController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/sixToEight/api")
    public ResponseEntity<List<CourseViewDto>> getAllSixToEight(){
        try {
            List<CourseViewDto> all = courseService.getAllByAgeLimit(AgeLimit.SixToEight);
            return ResponseEntity.ok(all);
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/nineToTwelve/api")
    public ResponseEntity<List<CourseViewDto>> getAllNineToTwelve(){
        try {
            List<CourseViewDto> all = courseService.getAllByAgeLimit(AgeLimit.NineToTwelve);
            return ResponseEntity.ok(all);
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/thirteenToFifteen/api")
    public ResponseEntity<List<CourseViewDto>> getAllThirteenToFifteen(){
        try {
            List<CourseViewDto> all = courseService.getAllByAgeLimit(AgeLimit.ThirteenToFifteen);
            return ResponseEntity.ok(all);
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/sixteenToEighteen/api")
    public ResponseEntity<List<CourseViewDto>> getAllSixteenToEighteen(){
        try {
            List<CourseViewDto> all = courseService.getAllByAgeLimit(AgeLimit.SixteenToEighteen);
            return ResponseEntity.ok(all);
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
