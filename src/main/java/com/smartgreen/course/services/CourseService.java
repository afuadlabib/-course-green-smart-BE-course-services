package com.smartgreen.course.services;

import com.smartgreen.course.models.BodyResponse;
import com.smartgreen.course.models.body.BodyMessage;
import com.smartgreen.course.models.dto.CourseDto;
import com.smartgreen.course.models.entity.Course;
import com.smartgreen.course.exceptions.NotFoundException;
import com.smartgreen.course.mappers.CourseMapper;
import com.smartgreen.course.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    @Autowired
    public CourseService(
            CourseRepository courseRepository
            , CourseMapper courseMapper
    ) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    public List<Course>getAllCourse(){
        return courseRepository.findAll();
    }
    public CourseDto createCourse(Course course){
        return courseMapper
                .mapToDto(courseRepository.save(course));

    }
    public Optional<Course> findCourseById(String id)throws NotFoundException{
            Optional<Course> course = courseRepository.findById(id);
            if(course.isEmpty()){
                throw new NotFoundException("Course not found");
            }
            return course;
    }
    public Course updateCourse(String id,Course course){
        Optional<Course> findCourse = courseRepository.findById(id);
        if(findCourse.isEmpty()) throw new NotFoundException("Course not found");
        return courseRepository.save(course);

    }
    public BodyMessage deleteCourse(String id){
        Optional<Course> findCourse = courseRepository.findById(id);
        if(findCourse.isEmpty()) throw new NotFoundException("Course not found");
        courseRepository.deleteById(id);
        return BodyMessage.builder()
                .message("Course Deleted Success")
                .build();
    }
}
