package com.gym.gymapi.exercise;

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

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ExerciseControllerTest {

    @Autowired
    ExerciseController exerciseController;

    @MockBean
    ExerciseService exerciseService;

    @MockBean
    Auth0Client auth0Client;

    @MockBean
    JwtDecoder jwtDecoder;

    @Test
    void createExercise() {
        var exerciseCreateDTO = new ExerciseCreateDTO();

        Mockito.when(exerciseService.createExercise(exerciseCreateDTO))
               .thenReturn(new ExerciseViewDTO());

        var result = exerciseController.createExercise(exerciseCreateDTO);

        assertThat(result).isNotNull();
    }

    @Test
    void getExercise() {
        var exerciseViewDTO = new ExerciseViewDTO();
        exerciseViewDTO.setId(UUID.randomUUID());

        Mockito.when(exerciseService.getExercise(exerciseViewDTO.getId()))
               .thenReturn(exerciseViewDTO);

        var result = exerciseController.getExercise(exerciseViewDTO.getId());

        assertThat(result).isNotNull();
    }
}
