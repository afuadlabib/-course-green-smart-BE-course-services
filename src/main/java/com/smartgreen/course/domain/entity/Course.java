package com.smartgreen.course.domain.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "courses")
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Course extends History {
    @Id
    String id;
    String name;
}
