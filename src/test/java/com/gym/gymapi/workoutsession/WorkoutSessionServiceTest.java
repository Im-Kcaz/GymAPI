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

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class WorkoutSessionServiceTest {

    @Autowired
    WorkoutSessionService workoutSessionService;

    @MockBean
    WorkoutSessionRepository workoutSessionRepository;

    @Autowired
    WorkoutSessionMapper workoutSessionMapper;

    @MockBean
    Auth0Client auth0Client;

    @MockBean
    JwtDecoder jwtDecoder;

    @Test
    void testCreateWorkoutSession() {
        var workoutSessionCreateDTO = new WorkoutSessionCreateDTO();

        var workoutSession = workoutSessionMapper.convertCreateDTOToEntity(workoutSessionCreateDTO);
        workoutSession.setId(UUID.randomUUID());

        Mockito.when(workoutSessionRepository.save(any(WorkoutSession.class)))
               .thenReturn(workoutSession);

        var result = workoutSessionService.createWorkoutSession(workoutSessionCreateDTO);

        assertThat(result).isNotNull();
    }

    @Test
    void testGetWorkoutSession() {
        var workoutSessionDTO = new WorkoutSessionViewDTO();
        workoutSessionDTO.setId(UUID.randomUUID());

        var workoutSession = workoutSessionMapper.convertViewDTOToEntity(workoutSessionDTO);
        workoutSession.setId(workoutSessionDTO.getId());

        Mockito.when(workoutSessionRepository.findById(workoutSession.getId()))
               .thenReturn(Optional.of(workoutSession));

        var result = workoutSessionService.getWorkoutSession(workoutSessionDTO.getId());

        assertThat(result).isNotNull();
    }

}
