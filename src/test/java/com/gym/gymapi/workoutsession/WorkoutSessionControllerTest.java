package com.gym.gymapi.workoutsession;

import com.gym.gymapi.security.Auth0Client;
import com.gym.gymapi.workoutsession.dto.WorkoutSession;
import com.gym.gymapi.workoutsession.dto.WorkoutSessionCreateDTO;
import com.gym.gymapi.workoutsession.dto.WorkoutSessionViewDTO;
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
        var workoutSessionCreateDTO = new WorkoutSessionCreateDTO();

        Mockito.when(workoutSessionService.createWorkoutSession(workoutSessionCreateDTO))
               .thenReturn(new WorkoutSessionViewDTO());

        var result = workoutSessionController.createWorkoutSession(workoutSessionCreateDTO);

        assertThat(result).isNotNull();
    }

    @Test
    void getWorkoutSession() {
        var id = UUID.randomUUID();

        Mockito.when(workoutSessionService.getWorkoutSession(id))
               .thenReturn(new WorkoutSessionViewDTO());

        var result = workoutSessionController.getWorkoutSession(id);

        assertThat(result).isNotNull();
    }
}
