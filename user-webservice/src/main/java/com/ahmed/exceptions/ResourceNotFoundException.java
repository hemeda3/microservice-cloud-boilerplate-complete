package com.ahmed.exceptions;

public class ResourceNotFoundException extends RuntimeException {

  public ResourceNotFoundException(Long resourceId, String message) {
    super(message+resourceId);
    ;
  }
}
