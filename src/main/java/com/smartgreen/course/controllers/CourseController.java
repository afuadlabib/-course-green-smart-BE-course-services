package com.smartgreen.course.controllers;

import com.smartgreen.course.models.BodyResponse;
import com.smartgreen.course.models.body.BodyMessage;
import com.smartgreen.course.models.dto.CourseDto;
import com.smartgreen.course.models.entity.Course;
import com.smartgreen.course.services.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        List<Course> courses = courseService.getAllCourse();
        BodyResponse<Object> body = BodyResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .data(courses)
                .build();
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
        CourseDto createdCourse = courseService.createCourse(course);
        BodyResponse<?> body = BodyResponse
                .builder()
                .statusCode(HttpStatus.CREATED.value())
                .data(createdCourse)
                .build();
        return ResponseEntity
                .status(HttpStatus.CREATED.value())
                .contentType(MediaType.APPLICATION_JSON)
                .body(body);
    }

    @PostMapping(path = "/courses",
           produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createCourse1(@Valid @RequestBody Course course){
        return createCourse(course);
    }
    @GetMapping(path = "/courses/{id}")
    public ResponseEntity<?> findCourseById(@PathVariable String id){
        Optional<Course> course = courseService.findCourseById(id);
        BodyResponse<?> body = BodyResponse
                .builder()
                .statusCode(HttpStatus.OK.value())
                .data(course)
                .build();
        return ResponseEntity
                .status(200)
                .body(body);
    }

    @PutMapping(path = "/courses/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable String id, @RequestBody Course course){
        Course courseUpdated = courseService.updateCourse(id, course);
        BodyResponse<?> body = BodyResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .data(courseUpdated)
                .build();
        return ResponseEntity
                .status(200)
                .body(body);
    }
    @DeleteMapping(path = "/courses/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable String id){
        BodyMessage message =  courseService.deleteCourse(id);
        BodyResponse<?> body = BodyResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .data(message)
                .build();
        return ResponseEntity
                .status(200)
                .body(body);
    }
}
