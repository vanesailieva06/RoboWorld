package com.example.roboworld.service.impl;

import com.example.roboworld.model.dto.ReviewViewDto;
import com.example.roboworld.repository.ReviewRepository;
import com.example.roboworld.service.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
@Service
public class ReviewServiceImpl implements ReviewService {
    private final ModelMapper modelMapper;
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ModelMapper modelMapper, ReviewRepository reviewRepository) {
        this.modelMapper = modelMapper;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Page<ReviewViewDto> getAllReviews(Pageable pageable) {
        return reviewRepository.findAll(pageable).map(review -> modelMapper.map(review, ReviewViewDto.class));
    }
}
