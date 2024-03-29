package com.example.roboworld.model.entity;

import com.example.roboworld.model.entity.enums.AgeLimit;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course extends BaseEntity{
    private AgeLimit ageLimit;
    private User lecturer;
    private String title;
    private String description;
    private LocalDateTime start;
    private LocalDateTime end;
    private List<User> students;
    private List<Lecture> lectures;

    public Course() {
    }

    @Enumerated(EnumType.STRING)
    public AgeLimit getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(AgeLimit ageLimit) {
        this.ageLimit = ageLimit;
    }

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    public User getLecturer() {
        return lecturer;
    }

    public void setLecturer(User lecturer) {
        this.lecturer = lecturer;
    }

    @Column
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column
    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }
    @Column
    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }
    @ManyToMany(mappedBy = "signInCourses", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    public List<User> getStudents() {
        return students;
    }

    public void setStudents(List<User> students) {
        this.students = students;
    }

    @OneToMany(mappedBy = "course", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    public List<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }
}
