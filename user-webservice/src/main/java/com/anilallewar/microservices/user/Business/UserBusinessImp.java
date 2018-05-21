package com.anilallewar.microservices.user.Business;

import com.anilallewar.microservices.user.SearchSpecefication.SearchCriteria;
import com.anilallewar.microservices.user.SearchSpecefication.UserSpecification;
import com.anilallewar.microservices.user.UserRepository.UserRepository;
import com.anilallewar.microservices.user.dto.UserDTO;
import com.anilallewar.microservices.user.exceptions.ResourceNotFoundException;
import com.anilallewar.microservices.user.userpojos.User;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
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

     List<User>   userList2= userRepository.findAll(userSpecification);
      //  List<User>  userList= new ArrayList<>();
      //  userList.add(User.builder().id(1L).name("ahmed").role("foo").build());
  log.info(userRepository.save(User.builder().name("nameaa").role("role").build()).toString());

        List<UserDTO> userDTOList =userRepository.findAll().stream().map( user -> modelMapper.map(user,UserDTO.class))
                .collect(Collectors.toList());
         boolean throwException = true;

         if (throwException) {
        //     throw new ResourceNotFoundException(333333L,"This is my ResourceNotFoundException");
         }
         log.info("users findall"+userRepository.findAll().toString());
        return userDTOList;





    }

}

