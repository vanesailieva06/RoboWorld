package com.example.roboworld.web;

import com.example.roboworld.repository.UserRepository;
import com.example.roboworld.util.TestDataUserUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TestDataUserUtil testDataUserUtil;

    @BeforeEach
    public void setUp(){
//        testDataUserUtil.cleanUp();
    }
    @AfterEach
    public void teaDown(){
        testDataUserUtil.cleanUp();
    }
    private static final String TEST_USER_EMAIL = "pesho@example.com";

    @Test
    public void testRegisterUser() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/users/register")
                        .param("email", TEST_USER_EMAIL)
                        .param("fullName", "Petar Petrov")
                        .param("username", "pesho")
                        .param("password", "1234")
                        .param("confirmPassword", "1234")
                        .with(csrf())
        ).andExpect(status().is3xxRedirection());

        Assertions.assertEquals(1, userRepository.count());
        Assertions.assertEquals(TEST_USER_EMAIL, userRepository.findTopByEmail(TEST_USER_EMAIL).orElseThrow().getEmail());
    }

}