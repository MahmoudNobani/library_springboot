package com.example.library.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.library.Config.TeacherMapper;
import com.example.library.dto.TeacherDTO;
import com.example.library.model.Teacher;
import com.example.library.repository.TeacherRepository;
import com.example.library.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepository teacherRepository;
    private TeacherMapper teacherMapper;
    
    public TeacherServiceImpl(TeacherRepository teacherRepository, TeacherMapper teacherMapper) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
    }

    public List<TeacherDTO> getAllTeachers() {
        return teacherRepository.findAll().stream()
                .map(teacherMapper::toDto)
                .collect(Collectors.toList());
    }

    public TeacherDTO getTeacherById( Long id) {
        Teacher t = teacherRepository.findById(id).orElseThrow();
        return teacherMapper.toDto(t);
    }

    public TeacherDTO createTeacher(Teacher teacher) {
        Teacher teacher1 = teacherRepository.save(teacher);
        return teacherMapper.toDto(teacher1);
    }

    public TeacherDTO updateTeacher(Long id, Teacher teacherDetails) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow();
        teacher.setName(teacherDetails.getName());
        teacher.setCourses(teacherDetails.getCourses());
        Teacher teacher1 = teacherRepository.save(teacher);
        return teacherMapper.toDto(teacher1);
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
}
