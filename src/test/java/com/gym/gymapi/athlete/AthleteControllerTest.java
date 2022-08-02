package com.gym.gymapi.athlete;

import com.gym.gymapi.athlete.dto.AthleteCreateDTO;
import com.gym.gymapi.athlete.dto.AthleteViewDTO;
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
class AthleteControllerTest {

    @Autowired
    AthleteController athleteController;

    @Autowired
    AthleteMapper athleteMapper;

    @MockBean
    AthleteService athleteService;

    @MockBean
    public JwtDecoder jwtDecoder;

    @MockBean
    public Auth0Client auth0Client;

    @Test
    void createAthlete() {
        var athleteDTO = new AthleteCreateDTO();

        var athleteViewDTO = new AthleteViewDTO();
        athleteViewDTO.setId(UUID.randomUUID());

        Mockito.when(athleteService.createAthlete(athleteDTO))
               .thenReturn(athleteViewDTO);

        var result = athleteController.createAthlete(athleteDTO);

        assertThat(result).isNotNull()
                          .isEqualTo(athleteViewDTO);
    }

    @Test
    void getAthlete() {
        var athleteDTO = new AthleteViewDTO();
        athleteDTO.setId(UUID.randomUUID());

        Mockito.when(athleteService.getAthlete(athleteDTO.getId()))
               .thenReturn(athleteDTO);

        var result = athleteController.getAthlete(athleteDTO.getId());

        assertThat(result).isNotNull()
                          .isEqualTo(athleteDTO);
    }
}
