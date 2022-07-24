package com.gym.gymapi.workoutsession;

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
class WorkoutSessionControllerTest {

    @Autowired
    WorkoutSessionController workoutSessionController;

    @MockBean
    WorkoutSessionService workoutSessionService;

    @MockBean
    Auth0Client auth0Client;

    @MockBean
    JwtDecoder jwtDecoder;

    @Test
    void createWorkoutSession() {
        var workoutSessionDTO = new WorkoutSessionDTO();
        workoutSessionDTO.setId(UUID.randomUUID());

        Mockito.when(workoutSessionService.createWorkoutSession(workoutSessionDTO))
               .thenReturn(workoutSessionDTO);

        var result = workoutSessionController.createWorkoutSession(workoutSessionDTO);

        assertThat(result).isNotNull()
                          .isEqualTo(workoutSessionDTO);
    }

    @Test
    void getWorkoutSession() {
        var workoutSessionDTO = new WorkoutSessionDTO();
        workoutSessionDTO.setId(UUID.randomUUID());

        Mockito.when(workoutSessionService.getWorkoutSession(workoutSessionDTO.getId()))
               .thenReturn(workoutSessionDTO);

        var result = workoutSessionController.getWorkoutSession(workoutSessionDTO.getId());

        assertThat(result).isNotNull()
                          .isEqualTo(workoutSessionDTO);
    }
}
