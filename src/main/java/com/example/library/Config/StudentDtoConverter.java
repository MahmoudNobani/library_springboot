package com.example.library.Config;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.library.dto.StudentDTO;
import com.example.library.model.Student;
import com.example.library.repository.StudentRepository;

//@Configuration
public class StudentDtoConverter {

    @Autowired
    private StudentRepository studentRepository;

    public StudentDTO convertToDto(Student student) {
        return new StudentDTO(
            student.getId(),
            student.getName(),
            student.getCourses().stream().map(course -> course.getId()).collect(Collectors.toList())
        );
    }

}
