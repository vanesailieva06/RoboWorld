package com.example.roboworld.service.impl;

import com.example.roboworld.model.dto.LectureViewDto;
import com.example.roboworld.repository.LectureRepository;
import com.example.roboworld.service.LectureService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LectureServiceImpl implements LectureService {
    private final LectureRepository lectureRepository;
    private final ModelMapper modelMapper;

    public LectureServiceImpl(LectureRepository lectureRepository, ModelMapper modelMapper) {
        this.lectureRepository = lectureRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<LectureViewDto> getAllByCourseId(Long id) {
        return lectureRepository.findAllByCourse_Id(id)
                .stream().map(lecture -> {
                    return modelMapper.map(lecture, LectureViewDto.class);
                }).collect(Collectors.toList());
    }
}
