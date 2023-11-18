package com.smartgreen.course.models.dto;

import com.smartgreen.course.models.entity.History;
import lombok.*;

@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CourseDto extends History{
    private String id;
    private String name;
}
