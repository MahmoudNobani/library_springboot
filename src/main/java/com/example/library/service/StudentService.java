package com.example.library.service;

import java.util.List;

import com.example.library.dto.StudentDTO;
import com.example.library.model.Student;


public interface StudentService {

    public List<StudentDTO> getAllStudents();

    public StudentDTO getStudentById(Long id);

    public StudentDTO createStudent(Student student);

    public StudentDTO updateStudent(Long id, Student studentDetails);

    public void deleteStudent(Long id);
}
