package com.smartgreen.course.models.body;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ValidExceptionResponse {
    private int statusCode;
    private Date timeStamp;
    private String message;
    private List<String> errors;
}
