package com.gym.gymapi.athlete;

import com.gym.gymapi.security.Auth0Client;
import com.gym.gymapi.user.UserDTO;
import com.gym.gymapi.user.UserService;
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
class AthleteServiceTest {

    @Autowired
    AthleteService athleteService;

    @Autowired
    AthleteMapper athleteMapper;

    @MockBean
    AthleteRepository athleteRepository;

    @MockBean
    UserService userService;

    @MockBean
    Auth0Client auth0Client;

    @MockBean
    JwtDecoder jwtDecoder;

    @Test
    void testCreateAthlete() {
        var athleteDTO = new AthleteDTO();
        athleteDTO.setId(UUID.randomUUID());

        var userDTO = new UserDTO();
        userDTO.setId(UUID.randomUUID());

        athleteDTO.setUser(userDTO);

        var athlete = athleteMapper.convertDTOToAthlete(athleteDTO);
        athlete.setId(athleteDTO.getId());

        Mockito.when(athleteRepository.save(any(Athlete.class)))
               .thenReturn(athlete);

        Mockito.when(userService.getUser(userDTO.getId()))
               .thenReturn(userDTO);

        var result = athleteService.createAthlete(athleteDTO);

        assertThat(result).isNotNull();
    }

    @Test
    void testGetAthlete() {
        var athleteDTO = new AthleteDTO();
        athleteDTO.setId(UUID.randomUUID());

        var userDTO = new UserDTO();
        userDTO.setId(UUID.randomUUID());

        athleteDTO.setUser(userDTO);

        var athlete = athleteMapper.convertDTOToAthlete(athleteDTO);
        athlete.setId(athleteDTO.getId());

        Mockito.when(athleteRepository.findById(athlete.getId()))
               .thenReturn(Optional.of(athlete));

        var result = athleteService.getAthlete(athleteDTO.getId());

        assertThat(result).isNotNull();
    }

}
