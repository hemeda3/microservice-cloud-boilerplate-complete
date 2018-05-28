package com.ahmed.business;

import com.ahmed.dto.UserDTO;
import com.ahmed.exceptions.InputValidationException;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface IUserBusiness {

  List<UserDTO> findUser(final String key, final String operation, final String value)
      throws InputValidationException;

  UserDTO saveUser(UserDTO user) throws InputValidationException;
}
