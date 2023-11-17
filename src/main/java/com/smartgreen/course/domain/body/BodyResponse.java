package com.smartgreen.course.domain.body;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BodyResponse<T> {
    Integer statusCode;
    T data;
}
