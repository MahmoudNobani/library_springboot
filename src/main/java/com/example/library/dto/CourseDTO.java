package com.example.library.dto;

import java.util.List;

public class CourseDTO {
    
    private Long id;
    private String name;
    private List<Long> studentIds;
    private List<Long> teacherIds;

    // Constructors, getters, and setters

    public CourseDTO() {}

    public CourseDTO(Long id, String name, List<Long> studentIds, List<Long> teacherIds) {
        this.id = id;
        this.name = name;
        this.studentIds = studentIds;
        this.teacherIds = teacherIds;
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

    public List<Long> getStudentIds() {
        return studentIds;
    }

    public void setStudentIds(List<Long> studentIds) {
        this.studentIds = studentIds;
    }

    public List<Long> getTeacherIds() {
        return teacherIds;
    }

    public void setTeacherIds(List<Long> teacherIds) {
        this.teacherIds = teacherIds;
    }
}
