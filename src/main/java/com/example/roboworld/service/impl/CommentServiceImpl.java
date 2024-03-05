package com.example.roboworld.service.impl;

import com.example.roboworld.model.dto.CommentViewDto;
import com.example.roboworld.model.dto.NewCommentDto;
import com.example.roboworld.model.entity.Comment;
import com.example.roboworld.repository.CommentRepository;
import com.example.roboworld.repository.ForumRepository;
import com.example.roboworld.repository.UserRepository;
import com.example.roboworld.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final ForumRepository forumRepository;
    public CommentServiceImpl(CommentRepository commentRepository, ModelMapper modelMapper, UserRepository userRepository, ForumRepository forumRepository) {
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.forumRepository = forumRepository;
    }

    @Override
    public CommentViewDto createComment(NewCommentDto newCommentDto) {
        Comment comment = modelMapper.map(newCommentDto, Comment.class);
        comment.setUser(userRepository.findByUsername(newCommentDto.getUser()).orElseThrow());
        comment.setForum(forumRepository.findByTitle(newCommentDto.getForumTitle()).orElseThrow());
        comment.setDescription(newCommentDto.getMessage());
        comment.setCreated(LocalDateTime.now());
        Comment save = commentRepository.save(comment);
        CommentViewDto map = modelMapper.map(save, CommentViewDto.class);
        map.setUser(newCommentDto.getUser());
        map.setMessage(newCommentDto.getMessage());
        return map;
    }

    @Override
    public List<CommentViewDto> getComments(Long forumId) {
        List<CommentViewDto> collect = commentRepository.findAllByForum_Id(forumId).stream().map(
                comment -> {
                    CommentViewDto commentViewDto = modelMapper.map(comment, CommentViewDto.class);
                    commentViewDto.setUser(comment.getUser().getUsername());
                    commentViewDto.setMessage(comment.getDescription());
                    return commentViewDto;
                }
        ).collect(Collectors.toList());
        return collect;
    }
}
