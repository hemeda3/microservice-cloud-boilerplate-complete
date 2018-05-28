package com.ahmed.entities;

import com.ahmed.exceptions.ErrorMessages;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
  /** The id. */
  @Id @GeneratedValue @JsonIgnore private Long id;
  /** The name. */
  @NotNull(message = ErrorMessages.ERR_USER_NAME_EMPTY)
  @Column(unique = true)
  @Size(min = 2, max = 30, message = "error.role.size")
  private String name;
  /** The role. */
  @NotNull(message = ErrorMessages.ERR_USER_NAME_EMPTY)
  @Size(min = 2, max = 30, message = "error.role.size")
  private String role;
  /** the version for database lock . */
  @Version private Integer version;
}
