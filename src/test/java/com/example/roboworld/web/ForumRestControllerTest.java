package com.example.roboworld.web;

import com.example.roboworld.model.dto.NewCommentDto;
import com.example.roboworld.model.entity.Comment;
import com.example.roboworld.model.entity.Forum;
import com.example.roboworld.model.entity.User;
import com.example.roboworld.repository.CommentRepository;
import com.example.roboworld.repository.ForumRepository;
import com.example.roboworld.repository.UserRepository;
import com.example.roboworld.util.TestDataUserUtil;
import com.example.roboworld.util.TestDataUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.text.MatchesPattern;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class ForumRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ForumRepository forumRepository;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private TestDataUserUtil testDataUserUtil;
    @Autowired
    private TestDataUtil testDataUtil;

    private User testUser;

    private static final String COMMENT_1 = "hey Spring is cool!";
    private static final String COMMENT_2 = "Well... it is a bit trick sometimes... :(";
    @BeforeEach
    public void setUp(){
        testUser = testDataUserUtil.createTestUser("pesho");
        commentRepository.deleteAll();
    }

    @Autowired
    public void tearDown(){
//        testDataUserUtil.cleanUp();
        testDataUtil.cleanUpForum();
        commentRepository.deleteAll();
    }

    @Test
    @WithMockUser(roles = {"User"}, username = "user")
    public void testGetComments() throws Exception {
        Forum forum = testDataUtil.createForum("testTitle");
        initComments(forum);

        mockMvc.perform(get("/api/comments/"+ forum.getId())).
                andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = {"User"}, username = "pesho")
    public void testAddComment() throws Exception {
        NewCommentDto testComment = new NewCommentDto();
        testComment.setMessage(COMMENT_1);
        testComment.setUser(testUser.getUsername());
        testComment.setForumTitle("test title");
        var forum = testDataUtil.createForum("test title");
        mockMvc.perform(
                        post("/api/comments/" + forum.getId())
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(testComment))
                                .accept(MediaType.APPLICATION_JSON)
                                .with(csrf())
                )
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(header().string("Location", MatchesPattern.matchesPattern("/api/comments/"+ forum.getId() + "/" + commentRepository.findByDescription(COMMENT_1).get().getId())))
                .andExpect(jsonPath("$.message").value(is(COMMENT_1)));
    }


    private Forum initComments(Forum forum) {
        Comment comment = new Comment();
        comment.setForum(forum);
        comment.setCreated(LocalDateTime.now());
        comment.setUser(testUser);
        comment.setDescription(COMMENT_1);
        commentRepository.save(comment);
        Comment comment1 = new Comment();
        comment.setForum(forum);
        comment.setCreated(LocalDateTime.now());
        comment.setUser(testUser);
        comment.setDescription(COMMENT_2);
        commentRepository.save(comment1);
        forum.setComments(List.of(comment, comment1));
        return forum;
    }
}