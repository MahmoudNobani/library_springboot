package com.example.library.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.library.Config.StudentMapper;
import com.example.library.dto.StudentDTO;
import com.example.library.model.Student;
import com.example.library.repository.StudentRepository;
import com.example.library.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    private StudentMapper studentMapper;

    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(studentMapper::toDto)
                .collect(Collectors.toList());
    }

    public StudentDTO getStudentById(@PathVariable Long id) {
        Student student = studentRepository.findById(id).orElseThrow();
        return studentMapper.toDto(student);
    }

    public StudentDTO createStudent(@RequestBody Student student) {
        Student student1 = studentRepository.save(student);
        return studentMapper.toDto(student1);
    }

    public StudentDTO updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        Student student = studentRepository.findById(id).orElseThrow();
        student.setName(studentDetails.getName());
        student.setCourses(studentDetails.getCourses());
        Student student1 = studentRepository.save(student);
        return studentMapper.toDto(student1);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }
}
