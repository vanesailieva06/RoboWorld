package com.example.roboworld.web;

import com.example.roboworld.model.entity.Review;
import com.example.roboworld.repository.ReviewRepository;
import com.example.roboworld.util.TestDataUserUtil;
import com.example.roboworld.util.TestDataUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class HomeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TestDataUtil testDataUtil;

    @Autowired
    private TestDataUserUtil testDataUserUtil;

    @Autowired
    private ReviewRepository reviewRepository;
    @BeforeEach
    void setUp(){
        //testDataUserUtil.cleanUp();
        testDataUtil.cleanUpReview();
    }

    @AfterEach
    void tearDown(){
        testDataUtil.cleanUpReview();
        //testDataUserUtil.cleanUp();
    }

    private static final String TEST_TITLE = "test title";
    private static final String NAME_USER = "Test T.";
    private static final String TEST_ADMIN_USERNAME = "admin";
    private static final String TEST_USER_USERNAME = "user";


    @Test
    @WithMockUser(username = TEST_USER_USERNAME,roles = {"User"})
    public void addReviewWithUser() throws Exception {
        Review review = testDataUtil.createReview(NAME_USER);
        mockMvc.perform(
                MockMvcRequestBuilders.post("/review/add")
                                .param("description", "testtttttt")
                                .param("name", NAME_USER)
                                .with(csrf())
                ).andExpect(status().is3xxRedirection());

        assertEquals(2, reviewRepository.count());
    }
}