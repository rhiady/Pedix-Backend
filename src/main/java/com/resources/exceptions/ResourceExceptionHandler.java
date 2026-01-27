package com.resources.exceptions;

import com.services.exceptions.DatabaseException;
import com.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> ResourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resource not found with id ";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
        return  ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> DatabaseException(DatabaseException e, HttpServletRequest request) {
        String error = "Database error ";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
        return  ResponseEntity.status(status).body(err);
    }

}
