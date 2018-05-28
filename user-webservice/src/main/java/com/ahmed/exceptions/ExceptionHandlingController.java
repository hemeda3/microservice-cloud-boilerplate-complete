package com.ahmed.exceptions;

import lombok.extern.log4j.Log4j2;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
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
    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(InputValidationException.class)
  public ResponseEntity<ExceptionResponse> inputValidation(InputValidationException ex) {
    ExceptionResponse response = new ExceptionResponse();
    response.setErrorCode("INPUT-INVALID-DATA-1000");
    response.setErrorMessage(ex.getMessage());
    log.error(response.toString());

    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }
  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<ExceptionResponse> emptyInput(HttpMessageNotReadableException ex) {
    ExceptionResponse response = new ExceptionResponse();
    response.setErrorCode("INPUT-EMPTY-1001");
    response.setErrorMessage(ex.getMessage());
    log.error(response.toString());

    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }
  @ExceptionHandler(DataIntegrityViolationExceptionInstance.class)
  public ResponseEntity<ExceptionResponse> userAlreadyExist(DataIntegrityViolationExceptionInstance ex) {
    ExceptionResponse response = new ExceptionResponse();
    response.setErrorCode("USER-1002");
    response.setErrorMessage("User name already exist");
    log.error(response.toString());

    return new ResponseEntity<>(response, HttpStatus.CONFLICT);
  }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<ExceptionResponse> handleGenericErrors(RuntimeException e)
      throws RuntimeException {
    // Check for annotation
    if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
      // Rethrow Exception
      throw e;
    } else {
      // Provide your general exception handling here
      ExceptionResponse response = new ExceptionResponse();
      response.setErrorCode("GENRIC-INTERNAL-ERROR-01");
      response.setErrorMessage("Generic error happened ");
      log.error(response.toString() + e.getLocalizedMessage());

      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
