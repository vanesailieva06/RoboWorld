package com.example.roboworld.util;

import com.example.roboworld.model.entity.*;
import com.example.roboworld.model.entity.enums.AgeLimit;
import com.example.roboworld.model.entity.enums.RoleType;
import com.example.roboworld.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class TestDataUtil {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ForumRepository forumRepository;

    public Course createCourse(String title){

        Course course = new Course();
        course.setDescription("testttttttttttt");
        course.setEnd(LocalDateTime.of(2024, 5, 25, 0, 0));
        course.setStart(LocalDateTime.of(2024, 3, 12, 0, 0));
        course.setAgeLimit(AgeLimit.NineToTwelve);
        course.setTitle(title);

        User lecturer = new User();
        Role role = new Role();
        role.setRoleType(RoleType.Lecturer);
        roleRepository.save(role);
        lecturer.setRoles(List.of(role));
        lecturer.setPassword("1234");
        lecturer.setEmail("111@123");
        lecturer.setFullName("Test Testov");
        lecturer.setCourses(List.of(course));
        lecturer.setUsername("test lecturer");
        userRepository.save(lecturer);
        course.setLecturer(lecturer);
        courseRepository.save(course);


        return course;
    }

    public Review createReview(String name){
        Review review = new Review();
        User user = new User();
        Role role = new Role();
        role.setRoleType(RoleType.User);
        roleRepository.save(role);
        user.setRoles(List.of(role));
        user.setPassword("1234");
        user.setEmail("111@123");
        user.setFullName("Test Testov");
        user.setUsername("user");
        review.setUser(user);
        review.setDescription("testtttttttttt");
        review.setName(name);
        userRepository.save(user);
        reviewRepository.save(review);

        return review;
    }

    public Forum createForum(String forumTitle){
        Forum forum = new Forum();
        forum.setCreated(LocalDateTime.of(2024, 5,22,0, 0));
        forum.setDescription("testtttt");
        forum.setTitle(forumTitle);
        forumRepository.save(forum);
        return forum;
    }


    public void cleanUpCourse(){
        //roleRepository.deleteAll();
        //userRepository.deleteAll();
        courseRepository.deleteAll();
    }
    public void cleanUpReview(){
        reviewRepository.deleteAll();
    }
    public void cleanUpAfterCourse(){

        courseRepository.deleteAll();
    }

    public void cleanUpForum(){
        forumRepository.deleteAll();
    }
}
