package com.gym.gymapi.exercise;

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
class ExerciseServiceTest {

    @Autowired
    ExerciseService exerciseService;

    @MockBean
    ExerciseRepository exerciseRepository;

    @MockBean
    Auth0Client auth0Client;

    @MockBean
    JwtDecoder jwtDecoder;

    @Test
    void testCreateExercise() {
        var exerciseDTO = new ExerciseDTO();
        exerciseDTO.setId(UUID.randomUUID());
        exerciseDTO.setExerciseType(ExerciseType.BENCH.toString());
        exerciseDTO.setTargetReps(1);
        exerciseDTO.setTargetWeight(10.0f);
        exerciseDTO.setTargetRPE(8.0f);

        var mapper = new ExerciseMapper();
        var exercise = mapper.convertDTOToExercise(exerciseDTO);
        exercise.setId(exerciseDTO.getId());

        Mockito.when(exerciseRepository.save(any(Exercise.class)))
               .thenReturn(exercise);

        var result = exerciseService.createExercise(exerciseDTO);

        assertThat(result).isNotNull();
    }

    @Test
    void testGetExercise() {
        var exerciseDTO = new ExerciseDTO();
        exerciseDTO.setId(UUID.randomUUID());
        exerciseDTO.setExerciseType(ExerciseType.BENCH.toString());
        exerciseDTO.setTargetReps(1);
        exerciseDTO.setTargetWeight(10.0f);
        exerciseDTO.setTargetRPE(8.0f);

        var mapper = new ExerciseMapper();
        var exercise = mapper.convertDTOToExercise(exerciseDTO);
        exercise.setId(exerciseDTO.getId());

        Mockito.when(exerciseRepository.findById(exercise.getId()))
               .thenReturn(Optional.of(exercise));

        var result = exerciseService.getExercise(exerciseDTO.getId());

        assertThat(result).isNotNull();
    }

}
