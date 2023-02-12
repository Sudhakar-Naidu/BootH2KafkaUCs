package com.msn.miscellaneous;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class BootH2ExceptionHandler {
    @ExceptionHandler(NoResourceException.class)
    public ResponseEntity<?> noResourceException(NoResourceException ex, WebRequest request) {
        ExceptionDetails exceptionDetails = new ExceptionDetails(ex.getMessage(), "ERROR_101");
        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> excpetionHandler(Exception ex, WebRequest request) {
        ExceptionDetails exceptionDetails = new ExceptionDetails(ex.getMessage(), "ERROR_102");
        return new ResponseEntity<>(exceptionDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
