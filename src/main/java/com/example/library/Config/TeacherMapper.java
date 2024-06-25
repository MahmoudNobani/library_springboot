package com.example.library.Config;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.example.library.dto.TeacherDTO;
import com.example.library.model.Course;
import com.example.library.model.Teacher;


@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface TeacherMapper {

    TeacherMapper INSTANCE = Mappers.getMapper( TeacherMapper.class ); 

    
    //@Mapping(target = "courseIds", source = "courses")
    @Mapping(target = "courseIds", source = "courses", qualifiedByName = "convert")
    TeacherDTO toDto(Teacher teacher);

    @Named("convert") 
    public static Long convert(Course c) { 
        return c.getId(); 
    }

}
