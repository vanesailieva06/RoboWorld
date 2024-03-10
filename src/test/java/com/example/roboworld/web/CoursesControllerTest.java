package com.example.roboworld.web;

import com.example.roboworld.model.entity.Course;
import com.example.roboworld.repository.CourseRepository;
import com.example.roboworld.util.TestDataUserUtil;
import com.example.roboworld.util.TestDataUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CoursesControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private TestDataUtil testDataUtil;
    @Autowired
    private TestDataUserUtil testDataUserUtil;

    @BeforeEach
    public void setUp(){
        testDataUtil.cleanUpCourse();
        //testDataUserUtil.createTestUser("user");
    }

    @AfterEach
    public void tearDown(){
        testDataUtil.cleanUpCourse();
        testDataUserUtil.cleanUp();
    }
    private static final String TEST_TITLE="Test title";

    @Test
    public void testGetCourseDetailsWithAnonymous() throws Exception {
        Course course = testDataUtil.createCourse(TEST_TITLE);
        mockMvc.perform(get("/courses/{id}", course.getId())
                .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern("**/users/login"));
    }

    @Test
    @WithMockUser(roles = {"User"}, username = "user")
    public void testGetCourseDetailsWithUser() throws Exception{
        Course course = testDataUtil.createCourse(TEST_TITLE);
        mockMvc.perform(get("/courses/{id}", course.getId())
                .with(csrf()))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    @WithMockUser(roles = {"User"}, username = "user")
    public void testSignInUp() throws Exception{
        Course course = testDataUtil.createCourse(TEST_TITLE);
        testDataUserUtil.createTestUser("user");
        Assertions.assertEquals(0,courseRepository.findById(course.getId()).orElseThrow().getStudents().size());
        mockMvc.perform(get("/courses/signInUp/{id}", course.getId())
                .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/courses/"+ course.getId()));

        Assertions.assertEquals(1, courseRepository.findById(course.getId()).orElseThrow().getStudents().size());
    }
}