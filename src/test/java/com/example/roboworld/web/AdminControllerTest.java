package com.example.roboworld.web;

import com.example.roboworld.model.entity.Review;
import com.example.roboworld.model.entity.User;
import com.example.roboworld.repository.ReviewRepository;
import com.example.roboworld.repository.UserRepository;
import com.example.roboworld.util.TestDataUserUtil;
import com.example.roboworld.util.TestDataUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public
class AdminControllerTest {


    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private TestDataUtil testDataUtil;
    @Autowired
    private TestDataUserUtil testDataUserUtil;
    @Autowired
    private UserRepository userRepository;
    @BeforeEach
    public void setUp(){
        testDataUtil.cleanUpReview();
    }

    @AfterEach
    public void tearDown(){
        testDataUtil.cleanUpReview();
    }

    private static final String TEST_TITLE = "test title";
    private static final String NAME_USER = "Test T.";
    private static final String TEST_ADMIN_USERNAME = "admin";
    private static final String TEST_USER_USERNAME = "user";

    @Test
    @WithMockUser(username = TEST_ADMIN_USERNAME,roles = {"Admin"})
    public void deleteReviewWithAdmin() throws Exception {
        Review review = testDataUtil.createReview(TEST_TITLE);
        mockMvc.perform(
                get("/review/delete/{id}", review.getId())
                        .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"));
        Assertions.assertEquals(0, reviewRepository.count());

    }

    @Test
    public void getProfilesWithAnonymous() throws Exception {
        mockMvc.perform(get("/users/profiles")
                .with(csrf())).andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern("**/users/login"));
    }
    @Test
    @WithMockUser(roles = "User", username = TEST_USER_USERNAME)
    public void getProfilesWithUser() throws Exception {
        mockMvc.perform(get("/users/profiles")
                .with(csrf())).andExpect(status().is4xxClientError());
    }

    @Test
    @WithMockUser(roles = "Admin", username = TEST_ADMIN_USERNAME)
    public void getProfilesWithAdmin() throws Exception {
        mockMvc.perform(get("/users/profiles")
                .with(csrf()))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void deleteProfileWithAnonymous() throws Exception{
        User testUser = testDataUserUtil.createTestUser(TEST_USER_USERNAME);
        mockMvc.perform(get("/users/delete/{id}",testUser.getId())
                .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern("**/users/login"));

    }
    @Test
    @WithMockUser(roles = {"User"}, username = TEST_USER_USERNAME)
    public void deleteProfileWithUser() throws Exception{
        User testUser = testDataUserUtil.createTestUser(TEST_USER_USERNAME);
        mockMvc.perform(get("/users/delete/{id}", testUser.getId())
                .with(csrf()))
                .andExpect(status().is4xxClientError());
    }
    @Test
    @WithMockUser(roles = "Admin", username = TEST_ADMIN_USERNAME)
    public void deleteProfileWithAdmin() throws Exception{
        User testAdmin = testDataUserUtil.createTestAdmin(TEST_ADMIN_USERNAME);
        mockMvc.perform(get("/users/delete/{id}", testAdmin.getId())
                .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/users/profiles"));
        Assertions.assertEquals(0, userRepository.count());
    }
}