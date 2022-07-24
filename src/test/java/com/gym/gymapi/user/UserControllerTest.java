package com.gym.gymapi.user;

import com.gym.gymapi.security.Auth0Client;
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
        var userDTO = new UserDTO();
        userDTO.setId(UUID.randomUUID());
        userDTO.setFirstName("Test");
        userDTO.setLastName("Test");
        userDTO.setUserName("Test");
        userDTO.setEmail("Test@test.com");
        userDTO.setPassword("password");

        Mockito.when(userService.createUser(userDTO))
               .thenReturn(userDTO);

        var result = userController.createUser(userDTO);

        assertThat(result).isNotNull()
                           .isEqualTo(userDTO);
    }

    @Test
    void testGetUser() {
        var userDTO = new UserDTO();
        userDTO.setId(UUID.randomUUID());
        userDTO.setFirstName("Test");
        userDTO.setLastName("Test");
        userDTO.setUserName("Test");
        userDTO.setEmail("Test@test.com");
        userDTO.setPassword("password");

        Mockito.when(userService.getUser(userDTO.getId()))
               .thenReturn(userDTO);

        var result = userController.getUser(userDTO.getId());

        assertThat(result).isNotNull()
                           .isEqualTo(userDTO);
    }

}
