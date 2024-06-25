package com.example.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
