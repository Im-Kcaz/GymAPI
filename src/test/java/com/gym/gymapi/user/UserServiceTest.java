package com.gym.gymapi.user;

import com.gym.gymapi.security.Auth0Client;
import com.gym.gymapi.user.dto.User;
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

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @MockBean
    UserRepository userRepository;

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

        var uuid = UUID.randomUUID();

        var userViewDTO = new UserViewDTO();
        userViewDTO.setId(UUID.randomUUID());
        userViewDTO.setFirstName("Test");
        userViewDTO.setLastName("Test");
        userViewDTO.setUserName("Test");
        userViewDTO.setEmail("Test@test.com");
        var user = userMapper.convertCreateDTOToEntity(userCreateDTO);
        user.setId(uuid);

        Mockito.when(userRepository.save(any(User.class)))
               .thenReturn(user);

        var result = userService.createUser(userCreateDTO);

        assertThat(result).isNotNull()
                           .extracting(UserViewDTO::getEmail,
                                       UserViewDTO::getUserName,
                                       UserViewDTO::getFirstName,
                                       UserViewDTO::getLastName)
                           .containsExactly(userViewDTO.getEmail(),
                                            userViewDTO.getUserName(),
                                            userViewDTO.getFirstName(),
                                            userViewDTO.getLastName());
    }

    @Test
    void testGetUser() {
        var userCreateDTO = new UserCreateDTO();
        userCreateDTO.setFirstName("Test");
        userCreateDTO.setLastName("Test");
        userCreateDTO.setUserName("Test");
        userCreateDTO.setEmail("Test@test.com");
        userCreateDTO.setPassword("password");

        var uuid = UUID.randomUUID();

        var userViewDTO = new UserViewDTO();
        userViewDTO.setId(UUID.randomUUID());
        userViewDTO.setFirstName("Test");
        userViewDTO.setLastName("Test");
        userViewDTO.setUserName("Test");
        userViewDTO.setEmail("Test@test.com");

        var user = userMapper.convertCreateDTOToEntity(userCreateDTO);
        user.setId(uuid);

        Mockito.when(userRepository.findById(user.getId()))
               .thenReturn(Optional.of(user));

        var result = userService.getUser(user.getId());

        assertThat(result).isNotNull()
                           .extracting(UserViewDTO::getEmail,
                                       UserViewDTO::getUserName,
                                       UserViewDTO::getFirstName,
                                       UserViewDTO::getLastName)
                           .containsExactly(userViewDTO.getEmail(),
                                            userViewDTO.getUserName(),
                                            userViewDTO.getFirstName(),
                                            userViewDTO.getLastName());
    }

}
