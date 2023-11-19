package com.smartgreen.course.controllers;

import com.smartgreen.course.models.body.EntityResponse;
import com.smartgreen.course.models.body.Message;
import com.smartgreen.course.models.entity.Course;
import com.smartgreen.course.services.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/course-services")
public class CourseController {
    @Autowired
    CourseService courseService;
    @GetMapping
    public String welcome(){
        return """
                Welcome To Service Courses
                """;
    }
    @GetMapping(path = "/courses")
    public ResponseEntity<?> getAllCourse(){
        EntityResponse<Object> body = courseService.getAllCourse();

        return ResponseEntity
                .status(200)
                .body(body);
    }

    @PostMapping(path = "/courses",
   consumes = {
            MediaType.APPLICATION_FORM_URLENCODED_VALUE,
           MediaType.MULTIPART_FORM_DATA_VALUE,
   },
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> createCourse(@Valid Course course){
        EntityResponse<?> createdCourse = courseService.createCourse(course);
        return ResponseEntity
                .status(HttpStatus.CREATED.value())
                .contentType(MediaType.APPLICATION_JSON)
                .body(createdCourse);
    }

    @PostMapping(path = "/courses",
           produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createCourse1(@Valid @RequestBody Course course){

        return createCourse(course);
    }
    @GetMapping(path = "/courses/{id}")
    public ResponseEntity<?> findCourseById(@PathVariable String id){
        EntityResponse<?> body = courseService.findCourseById(id);

        return ResponseEntity
                .status(200)
                .body(body);
    }

    @PutMapping(path = "/courses/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable String id, @RequestBody Course course){
        EntityResponse<?> body = courseService.updateCourse(id, course);
        return ResponseEntity
                .status(200)
                .body(body);
    }
    @DeleteMapping(path = "/courses/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable String id){
        EntityResponse<?> body = courseService.deleteCourse(id);
        return ResponseEntity
                .status(200)
                .body(body);
    }
}
