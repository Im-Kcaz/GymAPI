package com.gym.gymapi.user;

import com.gym.gymapi.security.Auth0Client;
import com.gym.gymapi.user.dto.UserCreateDTO;
import com.gym.gymapi.user.dto.UserViewDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserControllerTest {

    @Autowired
    UserController userController;

    @MockBean
    UserService userService;

    @MockBean
    Auth0Client auth0Client;

    @MockBean
    JwtDecoder jwtDecoder;

    @Test
    void testCreateUser() {
        var userCreateDTO = new UserCreateDTO();
        userCreateDTO.setFirstName("Test");
        userCreateDTO.setLastName("Test");
        userCreateDTO.setUserName("Test");
        userCreateDTO.setEmail("Test@test.com");
        userCreateDTO.setPassword("password");

        var userViewDTO = new UserViewDTO();
        userViewDTO.setId(UUID.randomUUID());
        userViewDTO.setFirstName("Test");
        userViewDTO.setLastName("Test");
        userViewDTO.setUserName("Test");
        userViewDTO.setEmail("Test@test.com");

        Mockito.when(userService.createUser(userCreateDTO))
               .thenReturn(userViewDTO);

        var result = userController.createUser(userCreateDTO);

        assertThat(result).isNotNull()
                           .isEqualTo(userViewDTO);
    }

    @Test
    void testGetUser() {
        var userDTO = new UserViewDTO();
        userDTO.setId(UUID.randomUUID());
        userDTO.setFirstName("Test");
        userDTO.setLastName("Test");
        userDTO.setUserName("Test");
        userDTO.setEmail("Test@test.com");

        Mockito.when(userService.getUser(userDTO.getId()))
               .thenReturn(userDTO);

        var result = userController.getUser(userDTO.getId());

        assertThat(result).isNotNull()
                           .isEqualTo(userDTO);
    }

}
