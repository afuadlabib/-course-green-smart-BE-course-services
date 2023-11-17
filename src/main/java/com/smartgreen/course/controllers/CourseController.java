package com.smartgreen.course.controllers;

import com.smartgreen.course.domain.dto.CourseDto;
import com.smartgreen.course.domain.entity.Course;
import com.smartgreen.course.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course-services")
public class CourseController {
    @Autowired
    CourseService courseService;
    @GetMapping
    public String welcome(){
        var e = 12;
        return """
                Welcome To Service Courses
                """;
    }
    @GetMapping(path = "/courses")
    public ResponseEntity<?> getAllCourse(){
        return courseService.getAllCourse();
    }

    @PostMapping(path = "/courses"
//    consumes = MediaType.APPLICATION_JSON_VALUE
//    produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> createCourse(@RequestBody Course courseDto){
        return courseService.createCourse(courseDto);
    }
}
