package com.example.roboworld.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity{
    private String username;
    private String email;
    private String fullName;
    private String password;
    private List<Role> roles;
    private List<Course> courses;
    private List<Course> signInCourses;
    private List<Review> reviews;

    public User() {
    }

    @Column(nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(nullable = false)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @OneToMany(mappedBy = "lecturer", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @ManyToMany( fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    public List<Course> getSignInCourses() {
        return signInCourses;
    }

    public void setSignInCourses(List<Course> isSignIn) {
        this.signInCourses = isSignIn;
    }


    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
