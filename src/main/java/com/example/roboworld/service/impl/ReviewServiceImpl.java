package com.example.roboworld.service.impl;

import com.example.roboworld.model.dto.ReviewAddDto;
import com.example.roboworld.model.dto.ReviewViewDto;
import com.example.roboworld.model.entity.Review;
import com.example.roboworld.repository.ReviewRepository;
import com.example.roboworld.repository.UserRepository;
import com.example.roboworld.service.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
@Service
public class ReviewServiceImpl implements ReviewService {
    private final ModelMapper modelMapper;
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;

    public ReviewServiceImpl(ModelMapper modelMapper, ReviewRepository reviewRepository, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Page<ReviewViewDto> getAllReviews(Pageable pageable) {
        return reviewRepository.findAll(pageable).map(review -> modelMapper.map(review, ReviewViewDto.class));
    }

    @Override
    public void addReview(ReviewAddDto reviewAddDto, UserDetails userDetails) {
        Review review = modelMapper.map(reviewAddDto, Review.class);
        review.setUser(userRepository.findByUsername(userDetails.getUsername()).orElseThrow());
        reviewRepository.save(review);
    }
}
