package com.anilallewar.microservices.user.Business;

import com.anilallewar.microservices.user.Mappings.UserMapper;
import com.anilallewar.microservices.user.SearchSpecefication.SearchCriteria;
import com.anilallewar.microservices.user.SearchSpecefication.UserSpecification;
import com.anilallewar.microservices.user.UserRepository.UserRepository;
import com.anilallewar.microservices.user.dto.UserDTO;
import com.anilallewar.microservices.user.exceptions.InputValidationException;
import com.anilallewar.microservices.user.exceptions.ResourceNotFoundException;
import com.anilallewar.microservices.user.userpojos.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Component
public interface IUserBusiness {

     List<UserDTO> findUser(final String key, final String operation, final String value) throws InputValidationException;
     UserDTO saveUser(UserDTO user) throws InputValidationException;

}

