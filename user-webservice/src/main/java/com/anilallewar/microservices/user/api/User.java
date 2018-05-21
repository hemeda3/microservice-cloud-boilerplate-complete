package com.anilallewar.microservices.user.api;


import lombok.*;

@Data
@Builder
public class User {
    /** The  id. */
    private  Long id;
    /** The  name. */
    private  String name;
    /** The  role. */
    private  String role;
}