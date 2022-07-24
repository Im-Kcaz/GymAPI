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

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class AthletePreferenceServiceTest {

    @Autowired
    AthletePreferenceService athletePreferenceService;

    @MockBean
    AthletePreferenceRepository athletePreferenceRepository;

    @MockBean
    Auth0Client auth0Client;

    @MockBean
    JwtDecoder jwtDecoder;

    @Test
    void testCreateAthletePreference() {
        var athletePreferenceDTO = new AthletePreferenceDTO();
        athletePreferenceDTO.setId(UUID.randomUUID());

        var mapper = new AthletePreferenceMapper();
        var athletePreference = mapper.convertDTOToAthletePreference(athletePreferenceDTO);
        athletePreference.setId(athletePreferenceDTO.getId());

        Mockito.when(athletePreferenceRepository.save(any(AthletePreference.class)))
               .thenReturn(athletePreference);

        var result = athletePreferenceService.createAthletePreference(athletePreferenceDTO);

        assertThat(result).isNotNull();
    }

    @Test
    void testGetAthletePreference() {
        var athletePreferenceDTO = new AthletePreferenceDTO();
        athletePreferenceDTO.setId(UUID.randomUUID());

        var mapper = new AthletePreferenceMapper();
        var athletePreference = mapper.convertDTOToAthletePreference(athletePreferenceDTO);
        athletePreference.setId(athletePreferenceDTO.getId());

        Mockito.when(athletePreferenceRepository.findById(athletePreference.getId()))
               .thenReturn(Optional.of(athletePreference));

        var result = athletePreferenceService.getAthletePreference(athletePreferenceDTO.getId());

        assertThat(result).isNotNull();
    }

}
