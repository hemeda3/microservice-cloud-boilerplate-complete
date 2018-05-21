package com.anilallewar.microservices.user.api;

import java.util.List;

import com.anilallewar.microservices.user.Business.IUserBusiness;
import com.anilallewar.microservices.user.helpers.ExtractUrl;
import com.anilallewar.microservices.user.helpers.UrlKeyValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import com.anilallewar.microservices.user.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;

/**
 * REST endpoint for the user functionality
 * 
 * @author anilallewar
 *
 */
@Slf4j(topic = "users-logs")
@RestController
@RequestMapping("/users")
public class UserController {


     private  final IUserBusiness IUserBusiness;
	@Value("${mail.domain ?: google.com}")
	private String mailDomain;

    @Autowired
	UserController(IUserBusiness IUserBusiness)
	{
		this.IUserBusiness = IUserBusiness;
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
	 * //@param key
	 * //@param value
	 * @return List<UserDTO>
	 */
	@GetMapping
	public List<UserDTO> getUserByUserName(
			HttpServletRequest request
	)
	{
		final UrlKeyValue urlKeyValue= ExtractUrl.extractKeyValueFromUri(request.getQueryString());
		 List<UserDTO> userDTOList =  IUserBusiness.findUser(urlKeyValue.getKey(),"=",urlKeyValue.getValue());


        return userDTOList;
	}
}
