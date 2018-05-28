package com.ahmed.exceptions;

public class DataIntegrityViolationExceptionInstance extends RuntimeException {

  public DataIntegrityViolationExceptionInstance(String message) {
    super("User :" + message + "already exist");
  }
}
