package com.anilallewar.microservices.user.userpojos;


import com.anilallewar.microservices.user.exceptions.ErrorMessages;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /** The  id. */

    @Id
    @GeneratedValue
    private  Long id;
    /** The  name. */
    @NotNull(message = ErrorMessages.ERR_USER_NAME_EMPTY)
    @Size(min = 2, max = 30, message = "error.role.size")
    private  String name;
    /** The  role. */
    @NotNull(message = ErrorMessages.ERR_USER_NAME_EMPTY)
    @Size(min = 2, max = 30, message = "error.role.size")
    private  String role;
    /** the version for database lock .*/
    @Version
    private Integer version;

}