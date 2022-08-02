package com.gym.gymapi.workoutsession;

import com.gym.gymapi.workoutsession.dto.WorkoutSessionCreateDTO;
import com.gym.gymapi.workoutsession.dto.WorkoutSessionViewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.UUID;

@Service
public class WorkoutSessionService {

    @Autowired
    private WorkoutSessionRepository workoutSessionRepository;

    @Autowired
    private WorkoutSessionMapper workoutSessionMapper;

    @Transactional
    public WorkoutSessionViewDTO createWorkoutSession(WorkoutSessionCreateDTO workoutSessionCreateDTO) {
        var workoutSession = workoutSessionMapper.convertCreateDTOToEntity(workoutSessionCreateDTO);
        workoutSessionRepository.save(workoutSession);

        return workoutSessionMapper.convertEntityToViewDTO(workoutSession);
    }

    @Transactional
    public WorkoutSessionViewDTO getWorkoutSession(UUID id) {
        var workoutSession = workoutSessionRepository.findById(id)
                                                     .orElseThrow(NotFoundException::new);

        return workoutSessionMapper.convertEntityToViewDTO(workoutSession);
    }
}
