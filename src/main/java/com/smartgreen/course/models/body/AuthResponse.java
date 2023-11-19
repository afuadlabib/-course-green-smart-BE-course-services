package com.smartgreen.course.models.body;

public class AuthResponse<T> {
        private Integer statusCode;
        private String token;
        private T data;

}
