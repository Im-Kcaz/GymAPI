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

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @MockBean
    UserRepository userRepository;

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

        var mapper = new UserMapper();
        var user = mapper.convertDTOToUser(userDTO);
        user.setId(userDTO.getId());

        Mockito.when(userRepository.save(any(User.class)))
               .thenReturn(user);

        var result = userService.createUser(userDTO);

        assertThat(userDTO).isNotNull()
                           .extracting(UserDTO::getEmail,
                                       UserDTO::getUserName,
                                       UserDTO::getFirstName,
                                       UserDTO::getLastName)
                           .containsExactly(result.getEmail(),
                                            result.getUserName(),
                                            result.getFirstName(),
                                            result.getLastName());
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

        var mapper = new UserMapper();
        var user = mapper.convertDTOToUser(userDTO);
        user.setId(userDTO.getId());

        Mockito.when(userRepository.findById(user.getId()))
               .thenReturn(Optional.of(user));

        var result = userService.getUser(userDTO.getId());

        assertThat(result).isNotNull()
                           .extracting(UserDTO::getEmail,
                                       UserDTO::getUserName,
                                       UserDTO::getFirstName,
                                       UserDTO::getLastName)
                           .containsExactly(userDTO.getEmail(),
                                            userDTO.getUserName(),
                                            userDTO.getFirstName(),
                                            userDTO.getLastName());
    }

}
