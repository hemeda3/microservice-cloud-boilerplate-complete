package com.ahmed.microservices.user.unit;

import static org.mockito.BDDMockito.anyString;
import static org.mockito.BDDMockito.mock;
import static org.mockito.Mockito.when;

import com.ahmed.UserApplication;
import com.ahmed.business.IUserBusiness;
import com.ahmed.business.UserBusinessImp;
import com.ahmed.dto.UserDTO;
import com.ahmed.exceptions.InputValidationException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserApplication.class)
public class UserBusinessInTest {
  private IUserBusiness userBusiness;

  @Before
  public void setUp() {
    userBusiness = mock(UserBusinessImp.class);
  }

  @Test
  public void saveUser() {

    UserDTO userTobeSaved = UserDTO.builder().name("John").role("foo").build();

    when(userBusiness.saveUser(userTobeSaved)).thenReturn(userTobeSaved);
    UserDTO userDTOSaved = userBusiness.saveUser(userTobeSaved);

    Assert.assertEquals("John", userDTOSaved.getName());
    Assert.assertEquals("foo", userDTOSaved.getRole());
  }

  @Test
  public void findUserByKeyAndValue() {

    final String USER_KEY = "role";
    final String USER_VALUE = "foo";
    final String QUERY_OPERATION = "=";
    UserDTO user1 = UserDTO.builder().name("John").role("foo").build();
    List<UserDTO> userDTOS = new ArrayList<>();
    userDTOS.add(user1);
    when(userBusiness.findUser(USER_KEY, QUERY_OPERATION, USER_VALUE)).thenReturn(userDTOS);
    List<UserDTO> userDTOList = userBusiness.findUser(USER_KEY, QUERY_OPERATION, USER_VALUE);
    Assert.assertEquals("John", userDTOList.get(0).getName());
    Assert.assertEquals("foo", userDTOList.get(0).getRole());
  }

  @Test(expected = InputValidationException.class)
  public void whenUserKeyIsEmptyThenThrowInputValidationException() {

    when(userBusiness.findUser("", "", ""))
        .thenThrow(InputValidationException.class);
    userBusiness.findUser(anyString(), anyString(), anyString());
  }
}
