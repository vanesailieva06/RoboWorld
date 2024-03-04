package com.example.roboworld.model.dto;

public class ReviewAddDto {
    private String name;
    private String description;

    public ReviewAddDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
