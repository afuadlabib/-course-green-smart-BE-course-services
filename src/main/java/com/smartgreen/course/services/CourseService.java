package com.smartgreen.course.services;

import com.smartgreen.course.models.body.EntityResponse;
import com.smartgreen.course.models.body.Message;
import com.smartgreen.course.models.entity.Course;
import com.smartgreen.course.exceptions.NotFoundException;
import com.smartgreen.course.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    @Autowired
    public CourseService(
            CourseRepository courseRepository
    ) {
        this.courseRepository = courseRepository;
    }

    public EntityResponse<Object> getAllCourse(){
        List<Course> courses = courseRepository.findAll();
        return EntityResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .data(courses)
                .build();
    }
    public EntityResponse<Object> createCourse(Course course){
        Course createdCourse =  courseRepository.save(course);
        return EntityResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .data(createdCourse)
                .build();
    }
    public EntityResponse<Object> findCourseById(String id) throws NotFoundException{
            Course course =  courseRepository.findById(id)
                    .orElseThrow(()-> new NotFoundException("Course not found"));
            return EntityResponse
                    .builder()
                    .statusCode(HttpStatus.OK.value())
                    .data(course)
                    .build();

    }
    public EntityResponse<Object> updateCourse(String id, Course course) throws NotFoundException {
        courseRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Course not found"));
        Course courseUpdated = courseRepository.save(course);
        return EntityResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .data(courseUpdated)
                .build();
    }
    public EntityResponse<Object> deleteCourse(String id) throws NotFoundException {
        Course findCourse = courseRepository.findById(id).orElseThrow(()-> new NotFoundException("Course not found"));
        courseRepository.deleteById(id);
        Message message =  Message.builder()
                .message("Course with name: "+ findCourse.getName() +" is deleted success")
                .build();
        return EntityResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .data(message)
                .build();
    }
}
