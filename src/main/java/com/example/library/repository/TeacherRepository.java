package com.example.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    
}