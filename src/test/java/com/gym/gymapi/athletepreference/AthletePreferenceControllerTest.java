package com.gym.gymapi.athletepreference;

import com.gym.gymapi.athletepreference.dto.AthletePreferenceCreateDTO;
import com.gym.gymapi.athletepreference.dto.AthletePreferenceViewDTO;
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
        var athletePreferenceCreateDTO = new AthletePreferenceCreateDTO();
        athletePreferenceCreateDTO.setDistanceMeasurement("lb");
        athletePreferenceCreateDTO.setWeightMeasurement("lb");

        var athletePreferenceViewDTO = new AthletePreferenceViewDTO();
        athletePreferenceViewDTO.setDistanceMeasurement(athletePreferenceCreateDTO.getDistanceMeasurement());
        athletePreferenceViewDTO.setWeightMeasurement(athletePreferenceCreateDTO.getWeightMeasurement());

        Mockito.when(athletePreferenceService.createAthletePreference(athletePreferenceCreateDTO))
               .thenReturn(athletePreferenceViewDTO);

        var result = athletePreferenceController.createAthletePreference(athletePreferenceCreateDTO);

        assertThat(result).isNotNull()
                          .isEqualTo(athletePreferenceViewDTO);
    }

    @Test
    void getAthletePreference() {
        var athletePreferenceViewDTO = new AthletePreferenceViewDTO();
        athletePreferenceViewDTO.setId(UUID.randomUUID());
        athletePreferenceViewDTO.setWeightMeasurement("lb");
        athletePreferenceViewDTO.setDistanceMeasurement("lb");

        Mockito.when(athletePreferenceService.getAthletePreference(athletePreferenceViewDTO.getId()))
               .thenReturn(athletePreferenceViewDTO);

        var result = athletePreferenceController.getAthletePreference(athletePreferenceViewDTO.getId());

        assertThat(result).isNotNull()
                          .isEqualTo(athletePreferenceViewDTO);
    }
}
