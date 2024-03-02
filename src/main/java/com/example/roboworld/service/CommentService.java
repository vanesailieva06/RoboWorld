package com.example.roboworld.service;

import com.example.roboworld.model.dto.CommentViewDto;
import com.example.roboworld.model.dto.NewCommentDto;

import java.util.List;

public interface CommentService {
    CommentViewDto createComment(NewCommentDto newCommentDto);

    List<CommentViewDto> getComments(Long forumId);
}
