
package edu.practice.parking.error;

import edu.practice.parking.dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handle missing parking passes
    @ExceptionHandler(PassNotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(
            PassNotFoundException ex) {

        ApiError error = new ApiError(
                "NOT_FOUND",
                ex.getMessage()
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }

    // Handle invalid input
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiError> handleBadRequest(
            IllegalArgumentException ex) {

        ApiError error = new ApiError(
                "BAD_REQUEST",
                ex.getMessage()
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);
    }
}
