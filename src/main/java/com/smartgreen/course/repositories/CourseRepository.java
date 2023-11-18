package com.smartgreen.course.repositories;

import com.smartgreen.course.models.entity.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CourseRepository extends MongoRepository<Course, String> {
}
