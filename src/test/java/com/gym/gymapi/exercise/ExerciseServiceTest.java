package com.gym.gymapi.exercise;

import com.gym.gymapi.exercise.dto.Exercise;
import com.gym.gymapi.exercise.dto.ExerciseCreateDTO;
import com.gym.gymapi.exercise.dto.ExerciseViewDTO;
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

    @Autowired
    ExerciseMapper exerciseMapper;

    @MockBean
    ExerciseRepository exerciseRepository;

    @MockBean
    Auth0Client auth0Client;

    @MockBean
    JwtDecoder jwtDecoder;

    @Test
    void testCreateExercise() {
        var exerciseCreateDTO = new ExerciseCreateDTO();
        exerciseCreateDTO.setExerciseType(ExerciseType.BENCH.toString());
        exerciseCreateDTO.setTargetReps(1);
        exerciseCreateDTO.setTargetWeight(10.0f);
        exerciseCreateDTO.setTargetRPE(8.0f);

        var exercise = exerciseMapper.convertCreateDTOToEntity(exerciseCreateDTO);
        exercise.setId(UUID.randomUUID());

        Mockito.when(exerciseRepository.save(any(Exercise.class)))
               .thenReturn(exercise);

        var result = exerciseService.createExercise(exerciseCreateDTO);

        assertThat(result).isNotNull();
    }

    @Test
    void testGetExercise() {
        var exerciseViewDTO = new ExerciseViewDTO();
        exerciseViewDTO.setId(UUID.randomUUID());
        exerciseViewDTO.setExerciseType(ExerciseType.BENCH.toString());
        exerciseViewDTO.setTargetWeight(10.0f);
        exerciseViewDTO.setTargetRPE(8.0f);

        var exercise = exerciseMapper.convertViewDTOToEntity(exerciseViewDTO);
        exercise.setId(UUID.randomUUID());

        Mockito.when(exerciseRepository.findById(exercise.getId()))
               .thenReturn(Optional.of(exercise));

        var result = exerciseService.getExercise(exercise.getId());

        assertThat(result).isNotNull();
    }

}
