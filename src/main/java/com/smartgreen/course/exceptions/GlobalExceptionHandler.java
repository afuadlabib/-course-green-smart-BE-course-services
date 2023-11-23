package com.smartgreen.course.exceptions;

import com.smartgreen.course.models.body.ExceptionResponse;
import com.smartgreen.course.models.body.ValidExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(NotFoundException n){
        ExceptionResponse b = ExceptionResponse.builder()
                .message(n.getMessage())
                .timeStamp(new Date())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .build();

        return ResponseEntity
                .status(404)
                .body(b);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());

        ValidExceptionResponse body = ValidExceptionResponse.builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .message("Validation error")
                .timeStamp(new Date())
                .errors(errors)
                .build();

        return ResponseEntity.status(400).body(body);
    }
    @ExceptionHandler(UnAuthorizeException.class)
    public ResponseEntity<?> unAuthorize(UnAuthorizeException unAuthorizeException){
        ExceptionResponse b = ExceptionResponse.builder()
                .message(unAuthorizeException.getMessage())
                .timeStamp(new Date())
                .statusCode(HttpStatus.UNAUTHORIZED.value())
                .build();
        return ResponseEntity.status(401).body(b);
    }
    private Map<String, List<String>> getErrorsMap(List<String> errors) {
        Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);

        return errorResponse;
    }
}
