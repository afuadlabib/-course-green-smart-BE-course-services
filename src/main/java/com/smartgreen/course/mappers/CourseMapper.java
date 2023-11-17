package com.smartgreen.course.mappers;

import com.smartgreen.course.domain.dto.CourseDto;
import com.smartgreen.course.domain.entity.Course;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper extends Mapper<Course, CourseDto>{
    ModelMapper modelMapper;
    @Autowired
    CourseMapper (ModelMapper modelmapper){
        this.modelMapper = modelmapper;
    }
    public CourseDto mapToDto(Course course){
        return  modelMapper.map(course, CourseDto.class);
    }
    public Course mapFrom(CourseDto courseDto){
        return modelMapper.map(courseDto, Course.class);
    }
}
