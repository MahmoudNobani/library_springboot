package com.example.library.Config;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.library.model.Course;

@Mapper
public class HasIdMapper {

  HasIdMapper INSTANCE = Mappers.getMapper( HasIdMapper.class ); 
  final long toId(Course entity) {
    return entity.getId();
  }
}