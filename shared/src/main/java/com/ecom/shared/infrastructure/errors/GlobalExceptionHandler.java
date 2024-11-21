package com.ecom.shared.infrastructure.errors;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleException(Exception e) {
        ApiError apiError = new ApiError();
        apiError.setStatus(org.springframework.http.HttpStatus.valueOf(HttpStatus.SC_INTERNAL_SERVER_ERROR));
        apiError.setMessage(e.getMessage());
        return ResponseEntity.status(500).body(apiError);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiError> handleIllegalArgumentException(IllegalArgumentException e) {
        ApiError apiError = new ApiError();
        apiError.setMessage(e.getMessage());
        return ResponseEntity.status(400).body(apiError);
    }
}
