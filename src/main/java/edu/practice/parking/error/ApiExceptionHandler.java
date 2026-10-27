package edu.practice.parking.error;
import edu.practice.parking.dto.ApiError;import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
@RestControllerAdvice public class ApiExceptionHandler {
 // TODO Task 3: map IllegalArgumentException -> HTTP 400 and PassNotFoundException -> HTTP 404.
 // Each response body must use ApiError with BAD_REQUEST or NOT_FOUND.
}
