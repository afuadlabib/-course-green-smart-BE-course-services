package com.smartgreen.course.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BodyResponse<T> {
    private Integer statusCode;
    private T data;
}
