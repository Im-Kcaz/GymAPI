package com.gym.gymapi.athlete;

import com.gym.gymapi.athlete.dto.Athlete;
import com.gym.gymapi.athlete.dto.AthleteCreateDTO;
import com.gym.gymapi.security.Auth0Client;
import com.gym.gymapi.user.dto.User;
import com.gym.gymapi.user.dto.UserViewDTO;
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
        var athleteCreateDTO = new AthleteCreateDTO();

        athleteCreateDTO.setUserId(UUID.randomUUID());

        var athlete = athleteMapper.convertCreateDTOToEntity(athleteCreateDTO);
        UUID expectedAthleteId = UUID.randomUUID();
        athlete.setId(expectedAthleteId);

        Mockito.when(athleteRepository.save(any(Athlete.class)))
               .thenReturn(athlete);

        Mockito.when(userService.getUser(athleteCreateDTO.getUserId()))
               .thenReturn(new UserViewDTO());

        var result = athleteService.createAthlete(athleteCreateDTO);

        assertThat(result).isNotNull();
    }

    @Test
    void testGetAthlete() {
        var athlete = new Athlete();
        athlete.setId(UUID.randomUUID());

        var user = new User();
        user.setId(UUID.randomUUID());
        athlete.setUser(user);

        Mockito.when(athleteRepository.findById(athlete.getId()))
               .thenReturn(Optional.of(athlete));

        Mockito.when(userService.getUser(user.getId()))
               .thenReturn(new UserViewDTO());

        var result = athleteService.getAthlete(athlete.getId());

        assertThat(result).isNotNull();
    }

}
