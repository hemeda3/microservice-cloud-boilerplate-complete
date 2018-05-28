package com.ahmed.exceptions;

public class InputValidationException extends RuntimeException {

  public InputValidationException(String message) {
    super("This parameter " + message + " is not valid {empty or null }");
  }
}
