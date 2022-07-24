package com.gym.gymapi.workoutsession;

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
    public WorkoutSessionDTO createWorkoutSession(WorkoutSessionDTO workoutSessionDTO) {
        var workoutSession = workoutSessionMapper.convertDTOToWorkoutSession(workoutSessionDTO);
        workoutSessionRepository.save(workoutSession);

        return workoutSessionMapper.convertWorkoutSessionToDTO(workoutSession);
    }

    @Transactional
    public WorkoutSessionDTO getWorkoutSession(UUID id) {
        var workoutSession = workoutSessionRepository.findById(id)
                                                     .orElseThrow(NotFoundException::new);

        return workoutSessionMapper.convertWorkoutSessionToDTO(workoutSession);
    }
}
