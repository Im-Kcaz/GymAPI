package com.gym.gymapi.user;

import com.gym.gymapi.security.Auth0Client;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @MockBean
    Auth0Client auth0Client;

    @MockBean
    JwtDecoder jwtDecoder;

    @Test
    void testConvertUserToDTO() {
        var user = new User();
        user.setEmail("test@test.com");
        user.setUserName("Test");
        user.setFirstName("Test");
        user.setFirstName("Test");

        var userDTO = userMapper.convertUserToDTO(user);

        assertThat(user).extracting(User::getEmail, User::getUserName, User::getFirstName, User::getLastName)
                        .containsExactly(userDTO.getEmail(),
                                         userDTO.getUserName(),
                                         userDTO.getFirstName(),
                                         userDTO.getLastName());
    }

    @Test
    void testConvertDTOToUser() {
        var userDTO = new UserDTO();
        userDTO.setEmail("test@test.com");
        userDTO.setUserName("Test");
        userDTO.setFirstName("Test");
        userDTO.setFirstName("Test");

        var user = userMapper.convertDTOToUser(userDTO);

        assertThat(userDTO).extracting(UserDTO::getEmail,
                                       UserDTO::getUserName,
                                       UserDTO::getFirstName,
                                       UserDTO::getLastName)
                           .containsExactly(user.getEmail(),
                                            user.getUserName(),
                                            user.getFirstName(),
                                            user.getLastName());
    }
}
