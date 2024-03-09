package com.example.roboworld.service;

import com.example.roboworld.model.dto.LectureViewDto;

import java.util.List;

public interface LectureService {
    List<LectureViewDto> getAllByCourseId(Long id);
}
