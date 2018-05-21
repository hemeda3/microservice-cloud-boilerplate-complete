package com.anilallewar.microservices.user.api.Mappings;

import com.anilallewar.microservices.user.api.User;
import com.anilallewar.microservices.user.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper  {

        UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

        @Mapping(source = "numberOfSeats", target = "seatCount")
        UserDTO carToCarDto(User user);
    }

}