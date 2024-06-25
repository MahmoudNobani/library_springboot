package com.example.library.service;

import java.util.List;

import com.example.library.dto.CourseDTO;
import com.example.library.model.Course;

public interface CourseService {

    public List<CourseDTO> getAllCourses();

    public CourseDTO getCourseById( Long id);

    public CourseDTO createCourse(Course course);

    public CourseDTO updateCourse(Long id, Course courseDetails);

    public void deleteCourse(Long id);
}
