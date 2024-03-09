package com.example.roboworld.model.dto;

import java.time.LocalDateTime;

public class LectureViewDto {
    private String lectureTitle;

    private LocalDateTime started;
    private LocalDateTime ended;

    public LectureViewDto() {
    }

    public String getLectureTitle() {
        return lectureTitle;
    }

    public void setLectureTitle(String lectureTitle) {
        this.lectureTitle = lectureTitle;
    }



    public LocalDateTime getStarted() {
        return started;
    }

    public void setStarted(LocalDateTime started) {
        this.started = started;
    }

    public LocalDateTime getEnded() {
        return ended;
    }

    public void setEnded(LocalDateTime ended) {
        this.ended = ended;
    }
}
