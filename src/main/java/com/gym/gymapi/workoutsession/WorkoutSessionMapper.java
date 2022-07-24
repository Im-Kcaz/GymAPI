package com.gym.gymapi.workoutsession;

import org.springframework.stereotype.Component;

@Component
public class WorkoutSessionMapper {

    public WorkoutSession convertDTOToWorkoutSession(WorkoutSessionDTO workoutSessionDTO) {
        if (workoutSessionDTO == null) {
            return null;
        }

        var workoutSession = new WorkoutSession();
        workoutSession.setDate(workoutSessionDTO.getDate());
        workoutSession.setTime(workoutSessionDTO.getTime());

        return workoutSession;
    }

    public WorkoutSessionDTO convertWorkoutSessionToDTO(WorkoutSession workoutSession) {
        if (workoutSession == null) {
            return null;
        }

        var workoutSessionDTO = new WorkoutSessionDTO();
        workoutSessionDTO.setId(workoutSession.getId());
        workoutSessionDTO.setDate(workoutSession.getDate());
        workoutSessionDTO.setTime(workoutSession.getTime());

        return workoutSessionDTO;
    }
}
