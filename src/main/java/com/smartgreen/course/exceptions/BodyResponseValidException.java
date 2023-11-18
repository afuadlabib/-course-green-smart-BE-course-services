package com.smartgreen.course.exceptions;

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
public class BodyResponseValidException {
    private int statusCode;
    private Date timeStamp;
    private List<String> errorsMessage;
}
