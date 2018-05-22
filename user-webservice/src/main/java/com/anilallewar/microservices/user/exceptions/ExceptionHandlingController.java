package com.anilallewar.microservices.user.exceptions;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Log4j2
public class ExceptionHandlingController {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFound(ResourceNotFoundException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("GENRAL-2000");
        response.setErrorMessage(ex.getMessage());
log.error(response.toString());
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InputValidationException.class)
    public ResponseEntity<ExceptionResponse> inputValidation(InputValidationException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("INPUT-1001");
        response.setErrorMessage(ex.getMessage());
        log.error(response.toString());

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

     @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponse>  handleConflict(RuntimeException e) throws RuntimeException {
        // Check for annotation
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            // Rethrow Exception
            throw e;
        }
        else {
            // Provide your general exception handling here
            ExceptionResponse response = new ExceptionResponse();
            response.setErrorCode("GENRIC-INTERNAL-ERROR");
            response.setErrorMessage("Generic error happen");
            log.error(response.toString());

            return new ResponseEntity<ExceptionResponse>(response, HttpStatus.CONFLICT);

        }
    }
}