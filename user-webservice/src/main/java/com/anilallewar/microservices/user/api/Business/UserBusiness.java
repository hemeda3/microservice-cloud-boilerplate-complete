package com.anilallewar.microservices.user.api.Business;

import com.anilallewar.microservices.user.api.SearchSpecefication.SearchCriteria;
import com.anilallewar.microservices.user.api.SearchSpecefication.UserSpecification;
import com.anilallewar.microservices.user.api.User;
import com.anilallewar.microservices.user.api.UserRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBusiness {

    private final UserRepository userRepository;

    @Autowired
    UserBusiness(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public List<User> findUser(final String key,final String operation, final String value) {
        SearchCriteria searchCriteria=   new SearchCriteria(key
                , operation, value);
        UserSpecification userSpecification =
                new UserSpecification( new SearchCriteria(key
                        , operation, value));
      return  userRepository.findAll(userSpecification);



    }

}

