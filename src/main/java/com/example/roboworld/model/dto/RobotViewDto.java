package com.example.roboworld.model.dto;

public class RobotViewDto {
    private String name;
    private String color;
    private String purpose;
    private String speaking;
    private String description;

    public RobotViewDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getSpeaking() {
        return speaking;
    }

    public void setSpeaking(String speaking) {
        this.speaking = speaking;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
