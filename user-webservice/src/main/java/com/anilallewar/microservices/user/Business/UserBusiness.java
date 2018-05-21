package com.anilallewar.microservices.user.Business;

import com.anilallewar.microservices.user.Mappings.UserMapper;
import com.anilallewar.microservices.user.SearchSpecefication.SearchCriteria;
import com.anilallewar.microservices.user.SearchSpecefication.UserSpecification;
import com.anilallewar.microservices.user.UserRepository.UserRepository;
import com.anilallewar.microservices.user.dto.UserDTO;
import com.anilallewar.microservices.user.userpojos.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Component
public class UserBusiness {

    private final UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    UserBusiness(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public List<UserDTO> findUser(final String key, final String operation, final String value) {
        SearchCriteria searchCriteria=   new SearchCriteria(key, operation, value);
        UserSpecification userSpecification =
                new UserSpecification( new SearchCriteria(key, operation, value));

 //     List<User>  userList= userRepository.findAll(userSpecification);
        List<User>  userList= new ArrayList<>();
        userList.add(User.builder().id(1L).name("ahmed").role("foo").build());

        List<UserDTO> userDTOList =userList.stream().map( user -> modelMapper.map(user,UserDTO.class))
                .collect(Collectors.toList());

        return userDTOList;
      //  UserDTO userDTO = UserMapper.INSTANCE.userToUserDto(  );

  //      List<UserDTO> userDTOList =userList.stream()
     //           .map(p -> UserDTO.builder().)




    }

}

