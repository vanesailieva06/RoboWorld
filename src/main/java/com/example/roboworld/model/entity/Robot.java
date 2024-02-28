package com.example.roboworld.model.entity;

import com.example.roboworld.model.entity.enums.Color;
import com.example.roboworld.model.entity.enums.Purpose;
import jakarta.persistence.*;

@Entity
@Table(name = "robots")
public class Robot extends BaseEntity{
    private String robotName;
    private Color color;
    private Purpose purpose;
    private Boolean speaking;
    private User user;
    private String description;
    public Robot() {
    }

    @Column(nullable = false)
    public String getRobotName() {
        return robotName;
    }

    public void setRobotName(String robotName) {
        this.robotName = robotName;
    }

    @Enumerated(EnumType.STRING)
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Enumerated(EnumType.STRING)
    public Purpose getPurpose() {
        return purpose;
    }

    public void setPurpose(Purpose purpose) {
        this.purpose = purpose;
    }

    @Column
    public Boolean getSpeaking() {
        return speaking;
    }

    public void setSpeaking(Boolean speaking) {
        this.speaking = speaking;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
