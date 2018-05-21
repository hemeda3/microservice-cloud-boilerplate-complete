package com.anilallewar.microservices.user.userpojos;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@Entity
@AllArgsConstructor
public class User {
    /** The  id. */

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  Long id;
    /** The  name. */
    private  String name;
    /** The  role. */
    private  String role;
}