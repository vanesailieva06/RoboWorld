package com.example.roboworld.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RoboticsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(roles = {"User"}, username = "user")
    public void testGetEtymology() throws Exception {
        mockMvc.perform(get("/robotics/etymology").with(csrf()))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    @WithMockUser(roles = {"User"}, username = "user")
    public void testGetHistory() throws Exception{
        mockMvc.perform(get("/robotics/history").with(csrf()))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    @WithMockUser(roles = {"User"}, username = "user")
    public void testGetComponents() throws Exception{
        mockMvc.perform(get("/robotics/components").with(csrf()))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    @WithMockUser(roles = {"User"}, username = "user")
    public void testGetDirections() throws Exception{
        mockMvc.perform(get("/robotics/directions").with(csrf()))
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    @WithMockUser(roles = {"User"}, username = "user")
    public void testGetUsage() throws Exception{
        mockMvc.perform(get("/robotics/usage").with(csrf()))
                .andExpect(status().is2xxSuccessful());
    }
}