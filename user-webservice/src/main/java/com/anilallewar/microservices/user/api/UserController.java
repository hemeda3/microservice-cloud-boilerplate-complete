package com.anilallewar.microservices.user.api;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.anilallewar.microservices.user.api.Business.UserBusiness;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anilallewar.microservices.user.dto.UserDTO;

/**
 * REST endpoint for the user functionality
 * 
 * @author anilallewar
 *
 */
@RestController
@RequestMapping("/")
public class UserController {

	private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());
    private  final UserBusiness userBusiness;
	@Value("${mail.domain ?: google.com}")
	private String mailDomain;


	UserController(UserBusiness userBusiness)
	{
		this.userBusiness=userBusiness;
	}

	/**
	 * Return all users
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
	public List<UserDTO> getUsers() {

		return  null;
	}

	/**
	 * Return user associated with specific user name
	 * 
	 * @param userName
	 * @return
	 */
	@RequestMapping(value = "{userName}", method = RequestMethod.GET, headers = "Accept=application/json")
	public UserDTO getUserByUserName(@PathVariable("key") String key,
	                                 @PathVariable("value") String value)
	{
		UserDTO userDtoToReturn =  userBusiness.findUser(key,"=",value);
		return userDtoToReturn;
	}
}
