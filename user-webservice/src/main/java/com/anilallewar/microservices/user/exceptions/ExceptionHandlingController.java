package com.anilallewar.microservices.user.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionHandlingController {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFound(ResourceNotFoundException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("GENRAL-2000");
        response.setErrorMessage(ex.getMessage());
log.error(ex.toString());
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InputValidationException.class)
    public ResponseEntity<ExceptionResponse> inputValidation(InputValidationException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("INPUT-1001");
        response.setErrorMessage(ex.getMessage());
        log.error(ex.toString());

        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataIntegrityViolationExceptionInstance.class)
    public ResponseEntity<ExceptionResponse> conflict(DataIntegrityViolationExceptionInstance ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("USER-1002");
        response.setErrorMessage("User already exist");
        log.error(response.toString());

        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.CONFLICT);
    }
}