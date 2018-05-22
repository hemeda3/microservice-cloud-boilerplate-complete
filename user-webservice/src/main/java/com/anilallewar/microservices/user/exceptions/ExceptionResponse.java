package com.anilallewar.microservices.user.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ExceptionResponse {
    private  String exception;
    private  String errorCode;
    private String errorMessage;

}