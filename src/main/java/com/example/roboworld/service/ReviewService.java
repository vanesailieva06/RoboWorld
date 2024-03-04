package com.example.roboworld.service;

import com.example.roboworld.model.dto.ReviewAddDto;
import com.example.roboworld.model.dto.ReviewViewDto;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;

public interface ReviewService
{
    Page<ReviewViewDto> getAllReviews(Pageable pageable);

    void addReview(ReviewAddDto reviewAddDto, UserDetails userDetails);
}
