package com.example.library.Config;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.example.library.dto.StudentDTO;
import com.example.library.model.Course;
import com.example.library.model.Student;

//@Mapper(uses = HasIdMapper.class, componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper( StudentMapper.class ); 

    
    //@Mapping(target = "courseIds", source = "courses")
    @Mapping(target = "courseIds", source = "courses", qualifiedByName = "convert")
    StudentDTO toDto(Student student);

    @Named("convert") 
    public static Long convert(Course c) { 
        return c.getId(); 
    }
}


