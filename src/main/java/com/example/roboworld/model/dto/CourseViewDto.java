package com.example.roboworld.model.dto;

import com.example.roboworld.model.entity.enums.AgeLimit;

public class CourseViewDto {
    private String title;
    private String description;
    private AgeLimit ageLimit;

    public CourseViewDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AgeLimit getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(AgeLimit ageLimit) {
        this.ageLimit = ageLimit;
    }
}
