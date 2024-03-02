package com.example.roboworld.service;

import com.example.roboworld.model.dto.ForumViewDto;

import java.util.List;

public interface ForumService {
    List<ForumViewDto> getAll();

    ForumViewDto findById(Long id);

    List<ForumViewDto> findForumsWithoutThis(Long id);
}
