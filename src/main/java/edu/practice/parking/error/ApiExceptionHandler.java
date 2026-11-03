package edu.practice.parking.error;

import edu.practice.parking.dto.ApiError;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class ApiExceptionHandler {

    // TODO Task 3: map IllegalArgumentException -> HTTP 400 and PassNotFoundException -> HTTP 404.
    // Each response body must use ApiError with BAD_REQUEST or NOT_FOUND.
    @ExceptionHandler(PassNotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(PassNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError(String.valueOf(HttpStatus.NOT_FOUND.value()), e.getMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiError> handleInvalid(RuntimeException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(String.valueOf(HttpStatus.NOT_FOUND.value()), e.getMessage()));
    }

}
