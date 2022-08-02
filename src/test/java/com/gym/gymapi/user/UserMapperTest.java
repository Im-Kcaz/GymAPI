package com.gym.gymapi.user;

import com.gym.gymapi.security.Auth0Client;
import com.gym.gymapi.user.dto.User;
import com.gym.gymapi.user.dto.UserCreateDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(locations="classpath:application-test.properties")
class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @MockBean
    Auth0Client auth0Client;

    @MockBean
    JwtDecoder jwtDecoder;

    @Test
    void testConvertUserToUserViewDTO() {
        var user = new User();
        user.setEmail("test@test.com");
        user.setUserName("Test");
        user.setFirstName("Test");
        user.setFirstName("Test");

        var userDTO = userMapper.convertEntityToViewDTO(user);

        assertThat(user).extracting(User::getEmail, User::getUserName, User::getFirstName, User::getLastName)
                        .containsExactly(userDTO.getEmail(),
                                         userDTO.getUserName(),
                                         userDTO.getFirstName(),
                                         userDTO.getLastName());
    }

    @Test
    void testConvertUserCreateDTOToUser() {
        var userCreateDTO = new UserCreateDTO();
        userCreateDTO.setFirstName("Test");
        userCreateDTO.setLastName("Test");
        userCreateDTO.setUserName("Test");
        userCreateDTO.setEmail("Test@test.com");
        userCreateDTO.setPassword("password");
        var user = userMapper.convertCreateDTOToEntity(userCreateDTO);

        assertThat(userCreateDTO).extracting(UserCreateDTO::getEmail,
                                             UserCreateDTO::getUserName,
                                             UserCreateDTO::getFirstName,
                                             UserCreateDTO::getLastName)
                                 .containsExactly(user.getEmail(),
                                                  user.getUserName(),
                                                  user.getFirstName(),
                                                  user.getLastName());
    }
}
