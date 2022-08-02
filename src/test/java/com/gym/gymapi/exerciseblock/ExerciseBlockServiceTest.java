package com.gym.gymapi.exerciseblock;

import com.gym.gymapi.athlete.dto.Athlete;
import com.gym.gymapi.exerciseblock.dto.ExerciseBlock;
import com.gym.gymapi.exerciseblock.dto.ExerciseBlockCreateDTO;
import com.gym.gymapi.exerciseblock.dto.ExerciseBlockViewDTO;
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

    @Autowired
    ExerciseBlockMapper exerciseBlockMapper;

    @MockBean
    ExerciseBlockRepository exerciseBlockRepository;

    @MockBean
    Auth0Client auth0Client;

    @MockBean
    JwtDecoder jwtDecoder;

    @Test
    void testCreateExerciseBlock() {
        var exerciseBlockCreateDTO = new ExerciseBlockCreateDTO();

        var exerciseBlock = exerciseBlockMapper.convertCreateDTOToEntity(exerciseBlockCreateDTO);
        exerciseBlock.setId(UUID.randomUUID());

        var athlete = new Athlete();
        athlete.setId(UUID.randomUUID());
        exerciseBlock.setAthlete(athlete);
        exerciseBlockCreateDTO.setAthleteId(athlete.getId());

        Mockito.when(exerciseBlockRepository.save(any(ExerciseBlock.class)))
               .thenReturn(exerciseBlock);

        var result = exerciseBlockService.createExerciseBlock(exerciseBlockCreateDTO);

        assertThat(result).isNotNull();
    }

    @Test
    void testGetExerciseBlock() {
        var exerciseBlockViewDTO = new ExerciseBlockViewDTO();
        exerciseBlockViewDTO.setId(UUID.randomUUID());

        var exerciseBlock = exerciseBlockMapper.convertViewDTOToEntity(exerciseBlockViewDTO);
        exerciseBlock.setId(UUID.randomUUID());

        Mockito.when(exerciseBlockRepository.findById(exerciseBlock.getId()))
               .thenReturn(Optional.of(exerciseBlock));

        var result = exerciseBlockService.getExerciseBlock(exerciseBlock.getId());

        assertThat(result).isNotNull();
    }

}
