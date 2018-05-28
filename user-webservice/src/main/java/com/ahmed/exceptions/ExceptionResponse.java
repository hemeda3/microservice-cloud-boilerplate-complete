package com.ahmed.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class ExceptionResponse {
  private String exception;
  private String errorCode;
  private String errorMessage;
}
