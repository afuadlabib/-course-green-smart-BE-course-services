package com.smartgreen.course.services;

import com.smartgreen.course.domain.body.BodyResponse;
import com.smartgreen.course.domain.dto.CourseDto;
import com.smartgreen.course.domain.entity.Course;
import com.smartgreen.course.mappers.CourseMapper;
import com.smartgreen.course.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    @Autowired
    public CourseService(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    public ResponseEntity<?>getAllCourse(){
        List<Course> data = courseRepository.findAll();
        BodyResponse<Object> body = BodyResponse
                .builder()
                .statusCode(HttpStatus.OK.value())
                .data(data)
                .build();
        return ResponseEntity
                .status(200)
                .body(body);
    }

    public ResponseEntity<?> createCourse(Course course){
        CourseDto createdCourse = courseMapper.mapToDto(courseRepository.insert(course));
        BodyResponse<?> body = BodyResponse.builder()
                .statusCode(HttpStatus.CREATED.value())
                .data(createdCourse)
                .build();
        System.out.println(body);
        return ResponseEntity
                .status(HttpStatus.CREATED.value())
                .contentType(MediaType.APPLICATION_JSON)
                .body(body);
    }
}
