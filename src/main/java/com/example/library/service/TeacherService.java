package com.example.library.service;

import java.util.List;

import com.example.library.dto.TeacherDTO;
import com.example.library.model.Teacher;

public interface TeacherService {

    public List<TeacherDTO> getAllTeachers();

    public TeacherDTO getTeacherById(Long id);

    public TeacherDTO createTeacher(Teacher teacher);

    public TeacherDTO updateTeacher(Long id, Teacher teacherDetails);

    public void deleteTeacher(Long id);
}
