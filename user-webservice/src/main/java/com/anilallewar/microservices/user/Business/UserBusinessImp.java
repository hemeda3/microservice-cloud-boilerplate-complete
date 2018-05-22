package com.anilallewar.microservices.user.Business;

import com.anilallewar.microservices.user.SearchSpecefication.SearchCriteria;
import com.anilallewar.microservices.user.SearchSpecefication.UserSpecification;
import com.anilallewar.microservices.user.UserRepository.UserRepository;
import com.anilallewar.microservices.user.dto.UserDTO;
import com.anilallewar.microservices.user.exceptions.ErrorMessages;
import com.anilallewar.microservices.user.exceptions.InputValidationException;
import com.anilallewar.microservices.user.exceptions.ResourceNotFoundException;
import com.anilallewar.microservices.user.userpojos.User;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

 import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Transactional(readOnly = true)
@Component
@Log4j2
public class UserBusinessImp  implements IUserBusiness{

    private final UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    UserBusinessImp(final UserRepository userRepository,final  ModelMapper modelMapper){
        this.userRepository=userRepository;
        this.modelMapper=modelMapper;
    }

     @Override
    public List<UserDTO> findUser(final String key, final String operation, final String value) throws ResourceNotFoundException {
        SearchCriteria searchCriteria=   new SearchCriteria(key, operation, value);
        UserSpecification userSpecification =
                new UserSpecification( new SearchCriteria(key, operation, value));

         if(ObjectUtils.isEmpty(key))
         {
           throw new InputValidationException(key);
         }
         else
         if(ObjectUtils.isEmpty(value))
         {
             throw new InputValidationException(value);
         }

             List<UserDTO> userDTOList2 =userRepository.findAll(userSpecification).stream()
                     .map( user -> modelMapper.map(user,UserDTO.class))
                 .collect(Collectors.toList());

         return userDTOList2;
  }

@Override
@Transactional
    public UserDTO saveUser(UserDTO user)  {

        User userSaved=userRepository.save(modelMapper.map(user,User.class));
        UserDTO userDTO= modelMapper.map(userSaved,UserDTO.class);
       return  userDTO;
    }


}

