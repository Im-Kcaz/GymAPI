package com.gym.gymapi.user;

import com.gym.gymapi.security.Auth0Client;
import com.gym.gymapi.user.dto.UserCreateDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Testcontainers
@ActiveProfiles("integration-test")
class UserServiceIntegrationTest {

    @Autowired
    UserService userService;

    @Container
    private static final MySQLContainer<?> container = new MySQLContainer<>("mysql:8.0.29").withReuse(true);

    @MockBean
    JwtDecoder jwtDecoder;

    @MockBean
    Auth0Client auth0Client;

    @DynamicPropertySource
    public static void overrideProps(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.username", container::getUsername);
        registry.add("spring.datasource.password", container::getPassword);
    }

    @Test
    void testCreateUser() {
        var userCreateDTO = new UserCreateDTO();
        userCreateDTO.setFirstName("Test");
        userCreateDTO.setLastName("Test");
        userCreateDTO.setUserName("Test");
        userCreateDTO.setEmail("Test@test.com");
        userCreateDTO.setPassword("password");

        var result = userService.createUser(userCreateDTO);

        System.out.println(result);
        assertThat(result).isNotNull();
    }
}
