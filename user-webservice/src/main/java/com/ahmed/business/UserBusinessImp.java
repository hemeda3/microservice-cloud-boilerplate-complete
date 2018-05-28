package com.ahmed.business;

import com.ahmed.entities.User;
import com.ahmed.dto.UserDTO;
import com.ahmed.exceptions.InputValidationException;
import com.ahmed.exceptions.ResourceNotFoundException;
import com.ahmed.repositories.UserRepository;
import com.ahmed.searchspecefication.SearchCriteria;
import com.ahmed.searchspecefication.UserSpecification;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

@Transactional(readOnly = true)
@Component
@Log4j2
public class UserBusinessImp implements IUserBusiness {

  private final UserRepository userRepository;

  @Autowired private ModelMapper modelMapper;

  @Autowired
  UserBusinessImp(final UserRepository userRepository, final ModelMapper modelMapper) {
    this.userRepository = userRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public List<UserDTO> findUser(final String key, final String operation, final String value)
      throws ResourceNotFoundException {
    UserSpecification userSpecification =
        new UserSpecification(new SearchCriteria(key, operation, value));

    if (ObjectUtils.isEmpty(key)) {
      throw new InputValidationException(key);
    } else if (ObjectUtils.isEmpty(value)) {
      throw new InputValidationException(value);
    }

    return userRepository
        .findAll(userSpecification)
        .stream()
        .map(user -> modelMapper.map(user, UserDTO.class))
        .collect(Collectors.toList());
  }

  @Override
  @Transactional
  public UserDTO saveUser(UserDTO user) {

    User userSaved = userRepository.save(modelMapper.map(user, User.class));
    return modelMapper.map(userSaved, UserDTO.class);
  }
}
