package com.anilallewar.microservices.user.api.UserRepository;
import com.anilallewar.microservices.user.api.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends  JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

}