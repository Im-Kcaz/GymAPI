package com.gym.gymapi.workoutsession;

import com.gym.gymapi.workoutsession.dto.WorkoutSession;
import com.gym.gymapi.workoutsession.dto.WorkoutSessionCreateDTO;
import com.gym.gymapi.workoutsession.dto.WorkoutSessionViewDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkoutSessionMapper {

    @Autowired
    private ModelMapper modelMapper;

    public WorkoutSession convertViewDTOToEntity(WorkoutSessionViewDTO workoutSessionDTO) {
        if (workoutSessionDTO == null) {
            return null;
        }

        var workoutSession = new WorkoutSession();
        workoutSession.setDate(workoutSessionDTO.getDate());
        workoutSession.setTime(workoutSessionDTO.getTime());

        return workoutSession;
    }

    public WorkoutSession convertCreateDTOToEntity(WorkoutSessionCreateDTO workoutSessionCreateDTO) {
        return modelMapper.map(workoutSessionCreateDTO, WorkoutSession.class);
    }

    public WorkoutSessionViewDTO convertEntityToViewDTO(WorkoutSession workoutSession) {
        if (workoutSession == null) {
            return null;
        }

        var workoutSessionDTO = new WorkoutSessionViewDTO();
        workoutSessionDTO.setId(workoutSession.getId());
        workoutSessionDTO.setDate(workoutSession.getDate());
        workoutSessionDTO.setTime(workoutSession.getTime());

        return workoutSessionDTO;
    }
}
