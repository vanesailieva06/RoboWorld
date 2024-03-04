package com.example.roboworld.service;

import com.example.roboworld.model.dto.ReviewViewDto;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

public interface ReviewService
{
    Page<ReviewViewDto> getAllReviews(Pageable pageable);
}
