package com.gym.gymapi.exerciseblock;

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
class ExerciseBlockControllerTest {

    @Autowired
    ExerciseBlockController exerciseBlockController;

    @MockBean
    ExerciseBlockService exerciseBlockService;

    @MockBean
    Auth0Client auth0Client;

    @MockBean
    JwtDecoder jwtDecoder;

    @Test
    void createExerciseBlock() {
        var exerciseBlockDTO = new ExerciseBlockDTO();
        exerciseBlockDTO.setId(UUID.randomUUID());

        Mockito.when(exerciseBlockService.createExerciseBlock(exerciseBlockDTO))
               .thenReturn(exerciseBlockDTO);

        var result = exerciseBlockController.createExerciseBlock(exerciseBlockDTO);

        assertThat(result).isNotNull()
                          .isEqualTo(exerciseBlockDTO);
    }

    @Test
    void getExerciseBlock() {
        var exerciseBlockDTO = new ExerciseBlockDTO();
        exerciseBlockDTO.setId(UUID.randomUUID());

        Mockito.when(exerciseBlockService.getExerciseBlock(exerciseBlockDTO.getId()))
               .thenReturn(exerciseBlockDTO);

        var result = exerciseBlockController.getExerciseBlock(exerciseBlockDTO.getId());

        assertThat(result).isNotNull()
                          .isEqualTo(exerciseBlockDTO);
    }
}
