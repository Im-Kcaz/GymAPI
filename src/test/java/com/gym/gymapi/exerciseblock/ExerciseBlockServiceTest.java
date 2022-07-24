package com.gym.gymapi.exerciseblock;

import com.gym.gymapi.athlete.AthleteDTO;
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
class ExerciseBlockServiceTest {

    @Autowired
    ExerciseBlockService exerciseBlockService;

    @MockBean
    ExerciseBlockRepository exerciseBlockRepository;

    @MockBean
    Auth0Client auth0Client;

    @MockBean
    JwtDecoder jwtDecoder;

    @Test
    void testCreateExerciseBlock() {
        var exerciseBlockDTO = new ExerciseBlockDTO();
        exerciseBlockDTO.setId(UUID.randomUUID());

        var athleteDTO = new AthleteDTO();
        athleteDTO.setId(UUID.randomUUID());

        exerciseBlockDTO.setAthleteDTO(athleteDTO);

        var mapper = new ExerciseBlockMapper();
        var exerciseBlock = mapper.convertDTOToExerciseBlock(exerciseBlockDTO);
        exerciseBlock.setId(exerciseBlockDTO.getId());

        Mockito.when(exerciseBlockRepository.save(any(ExerciseBlock.class)))
               .thenReturn(exerciseBlock);

        var result = exerciseBlockService.createExerciseBlock(exerciseBlockDTO);

        assertThat(result).isNotNull();
    }

    @Test
    void testGetExerciseBlock() {
        var exerciseBlockDTO = new ExerciseBlockDTO();
        exerciseBlockDTO.setId(UUID.randomUUID());

        var athleteDTO = new AthleteDTO();
        athleteDTO.setId(UUID.randomUUID());

        exerciseBlockDTO.setAthleteDTO(athleteDTO);

        var mapper = new ExerciseBlockMapper();
        var exerciseBlock = mapper.convertDTOToExerciseBlock(exerciseBlockDTO);
        exerciseBlock.setId(exerciseBlockDTO.getId());

        Mockito.when(exerciseBlockRepository.findById(exerciseBlock.getId()))
               .thenReturn(Optional.of(exerciseBlock));

        var result = exerciseBlockService.getExerciseBlock(exerciseBlockDTO.getId());

        assertThat(result).isNotNull();
    }

}
