package com.smartgreen.course.models.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank
    @NotNull
    String name;
}
