package com.ahmed.api;

import com.ahmed.business.IUserBusiness;
import com.ahmed.dto.UserDTO;
import com.ahmed.helpers.ExtractUrl;
import com.ahmed.helpers.UrlKeyValue;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST endpoint for the user functionality
 *
 * @author Ahmed
 */
@Log4j2(topic = "users-logs")
@RestController
@RequestMapping("/users")
public class UserController {

  private final IUserBusiness iUserBusiness;

  @Autowired
  UserController(IUserBusiness iUserBusiness) {
    this.iUserBusiness = iUserBusiness;
  }

  @GetMapping
  ResponseEntity<List<UserDTO>> findUsers(HttpServletRequest request) {
    final UrlKeyValue urlKeyValue = ExtractUrl.extractKeyValueFromUri(request.getQueryString());
    List<UserDTO> userDTOList =
        iUserBusiness.findUser(urlKeyValue.getKey(), "=", urlKeyValue.getValue());

    return new ResponseEntity<>(userDTOList, HttpStatus.OK);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED) ResponseEntity<UserDTO>  saveUser(@RequestBody UserDTO userDTO) {

    UserDTO savedUser = iUserBusiness.saveUser(userDTO);
    return new ResponseEntity<UserDTO>(savedUser, HttpStatus.OK);
  }
}
