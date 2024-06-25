package com.example.library.dto;

import java.util.List;

public class TeacherDTO {
    
    private Long id;
    private String name;
    private List<Long> courseIds;

    // Constructors, getters, and setters

    public TeacherDTO() {}

    public TeacherDTO(Long id, String name, List<Long> courseIds) {
        this.id = id;
        this.name = name;
        this.courseIds = courseIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getCourseIds() {
        return courseIds;
    }

    public void setCourseIds(List<Long> courseIds) {
        this.courseIds = courseIds;
    }
}