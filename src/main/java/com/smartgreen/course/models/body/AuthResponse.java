package com.smartgreen.course.models.body;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AuthResponse<T> {
        private Integer statusCode;
        private String token;
        private T data;
}
