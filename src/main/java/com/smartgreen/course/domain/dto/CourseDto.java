package com.smartgreen.course.domain.dto;

import com.smartgreen.course.domain.entity.History;
import lombok.*;

@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CourseDto extends History{
    String id;
    String name;
}
