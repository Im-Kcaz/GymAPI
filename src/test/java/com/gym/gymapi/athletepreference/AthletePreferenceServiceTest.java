package com.gym.gymapi.athletepreference;

import com.gym.gymapi.athlete.AthleteService;
import com.gym.gymapi.athlete.dto.Athlete;
import com.gym.gymapi.athlete.dto.AthleteViewDTO;
import com.gym.gymapi.athletepreference.dto.AthletePreference;
import com.gym.gymapi.athletepreference.dto.AthletePreferenceCreateDTO;
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
class AthletePreferenceServiceTest {

    @Autowired
    AthletePreferenceService athletePreferenceService;

    @Autowired
    AthletePreferenceMapper athletePreferenceMapper;

    @MockBean
    AthletePreferenceRepository athletePreferenceRepository;

    @MockBean
    AthleteService athleteService;

    @MockBean
    Auth0Client auth0Client;

    @MockBean
    JwtDecoder jwtDecoder;

    @Test
    void testCreateAthletePreference() {
        var athletePreferenceCreateDTO = new AthletePreferenceCreateDTO();

        athletePreferenceCreateDTO.setAthleteId(UUID.randomUUID());

        var athletePreference = athletePreferenceMapper.convertCreateDTOToEntity(athletePreferenceCreateDTO);
        UUID expectedAthletePreferenceId = UUID.randomUUID();
        athletePreference.setId(expectedAthletePreferenceId);

        Mockito.when(athletePreferenceRepository.save(any(AthletePreference.class)))
               .thenReturn(athletePreference);

        Mockito.when(athleteService.getAthlete(athletePreferenceCreateDTO.getAthleteId()))
               .thenReturn(new AthleteViewDTO());

        var result = athletePreferenceService.createAthletePreference(athletePreferenceCreateDTO);

        assertThat(result).isNotNull();
    }

    @Test
    void testGetAthletePreference() {
        var athletePreference = new AthletePreference();
        athletePreference.setId(UUID.randomUUID());

        var athlete = new Athlete();
        athlete.setId(UUID.randomUUID());
        athletePreference.setAthlete(athlete);

        Mockito.when(athletePreferenceRepository.findById(athletePreference.getId()))
               .thenReturn(Optional.of(athletePreference));

        Mockito.when(athleteService.getAthlete(athlete.getId()))
               .thenReturn(new AthleteViewDTO());

        var result = athletePreferenceService.getAthletePreference(athletePreference.getId());

        assertThat(result).isNotNull();
    }

}
