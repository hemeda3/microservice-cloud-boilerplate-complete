package com.anilallewar.microservices.user.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public enum Roles {
    ROL(200, "OK"),
    failure(500, "Failure");

    private final int code;
    private final String msg;


}