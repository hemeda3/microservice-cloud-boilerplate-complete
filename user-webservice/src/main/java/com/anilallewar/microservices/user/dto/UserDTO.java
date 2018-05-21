package com.anilallewar.microservices.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
	/** The  id. */

	public Long id;

	/** The name . */
	public String name;

	/** The  role. */
	public String role;

}
