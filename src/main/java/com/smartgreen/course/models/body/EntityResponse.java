package com.smartgreen.course.models.body;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EntityResponse<T> {
    private Integer statusCode;
    private T data;
}
