package com.example.library.Config;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.example.library.dto.CourseDTO;
import com.example.library.model.Course;
import com.example.library.model.Student;
import com.example.library.model.Teacher;
import org.mapstruct.InjectionStrategy;


@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface CourseMapper {

    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    @Mapping(target = "studentIds", source = "students", qualifiedByName = "studentToId")
    @Mapping(target = "teacherIds", source = "teachers", qualifiedByName = "teacherToId")
    CourseDTO toDto(Course course);

    @Named("studentToId")
    static Long studentToId(Student student) {
        return student.getId();
    }

    @Named("teacherToId")
    static Long teacherToId(Teacher teacher) {
        return teacher.getId();
    }

}
