package com.gym.gymapi.athletepreference;

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
class AthletePreferenceControllerTest {

    @Autowired
    AthletePreferenceController athletePreferenceController;

    @MockBean
    AthletePreferenceService athletePreferenceService;

    @MockBean
    Auth0Client auth0Client;

    @MockBean
    JwtDecoder jwtDecoder;

    @Test
    void createAthletePreference() {
        var athletePreferenceDTO = new AthletePreferenceDTO();
        athletePreferenceDTO.setId(UUID.randomUUID());

        Mockito.when(athletePreferenceService.createAthletePreference(athletePreferenceDTO))
               .thenReturn(athletePreferenceDTO);

        var result = athletePreferenceController.createAthletePreference(athletePreferenceDTO);

        assertThat(result).isNotNull()
                          .isEqualTo(athletePreferenceDTO);
    }

    @Test
    void getAthletePreference() {
        var athletePreferenceDTO = new AthletePreferenceDTO();
        athletePreferenceDTO.setId(UUID.randomUUID());

        Mockito.when(athletePreferenceService.getAthletePreference(athletePreferenceDTO.getId()))
               .thenReturn(athletePreferenceDTO);

        var result = athletePreferenceController.getAthletePreference(athletePreferenceDTO.getId());

        assertThat(result).isNotNull()
                          .isEqualTo(athletePreferenceDTO);
    }
}
