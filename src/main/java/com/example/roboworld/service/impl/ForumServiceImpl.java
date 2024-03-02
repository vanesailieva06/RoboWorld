package com.example.roboworld.service.impl;

import com.example.roboworld.model.dto.ForumViewDto;
import com.example.roboworld.repository.ForumRepository;
import com.example.roboworld.service.ForumService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ForumServiceImpl implements ForumService {
    private final ForumRepository forumRepository;
    private final ModelMapper modelMapper;

    public ForumServiceImpl(ForumRepository forumRepository, ModelMapper modelMapper) {
        this.forumRepository = forumRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ForumViewDto> getAll() {
        return forumRepository.findAll().stream().map(forum -> modelMapper.map(forum, ForumViewDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ForumViewDto findById(Long id) {

        return modelMapper.map(forumRepository.findById(id).orElseThrow(), ForumViewDto.class);
    }

    @Override
    public List<ForumViewDto> findForumsWithoutThis(Long id) {

        return forumRepository.findAllByIdIsNot(id).stream().map(
                forum -> modelMapper.map(forum, ForumViewDto.class)
        ).collect(Collectors.toList());
    }
}
