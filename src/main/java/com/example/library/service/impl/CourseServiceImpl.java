package com.example.library.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.library.Config.CourseMapper;
import com.example.library.dto.CourseDTO;
import com.example.library.model.Course;
import com.example.library.repository.CourseRepository;
import com.example.library.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{

    private CourseRepository courseRepository;
    private CourseMapper courseMapper;

    
    public CourseServiceImpl(CourseRepository courseRepository, CourseMapper courseMapper) {
            this.courseRepository = courseRepository;
            this.courseMapper = courseMapper;
        }

    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(courseMapper::toDto)
                .collect(Collectors.toList());
    }

    public CourseDTO getCourseById(Long id) {
        Course c = courseRepository.findById(id).orElseThrow();
        return courseMapper.toDto(c);
    }

    public CourseDTO createCourse(Course course) {
        Course c = courseRepository.save(course);
        return courseMapper.toDto(c);
    }

    public CourseDTO updateCourse(Long id, Course courseDetails) {
        Course course = courseRepository.findById(id).orElseThrow();
        course.setName(courseDetails.getName());
        course.setStudents(courseDetails.getStudents());
        course.setTeachers(courseDetails.getTeachers());
        Course c = courseRepository.save(course);
        return courseMapper.toDto(c);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
