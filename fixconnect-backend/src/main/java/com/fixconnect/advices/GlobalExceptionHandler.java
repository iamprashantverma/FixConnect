package com.fixconnect.advices;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(IOException.class)
    public ResponseEntity<APIResponse<?>> handleCloudinaryNetworkIssues(IOException ex) {
        log.error("Cloudinary network issue: {}", ex.getMessage());
        return buildResponse(HttpStatus.GATEWAY_TIMEOUT, "Cloudinary network timeout or connectivity issue.");
    }

    //VALIDATION
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIResponse<?>> handleValidationErrors(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getFieldErrors().stream()
                .map(err -> String.format("[%s: %s]", err.getField(), err.getDefaultMessage()))
                .reduce((a, b) -> a + " " + b)
                .orElse("Validation failed.");
        log.warn("Validation failed: {}", message);
        return buildResponse(HttpStatus.BAD_REQUEST, message);
    }


    // GENERIC FALLBACK
    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponse<?>> handleGenericException(Exception ex) {
        log.error("Unhandled exception: {}", ex.getMessage(), ex);
        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong: " + ex.getMessage());
    }

    // Helper method
    private ResponseEntity<APIResponse<?>> buildResponse(HttpStatus status, String message) {
        APIError error = new APIError(status, message);
        return ResponseEntity.status(status).body(new APIResponse<>(error));
    }
}
