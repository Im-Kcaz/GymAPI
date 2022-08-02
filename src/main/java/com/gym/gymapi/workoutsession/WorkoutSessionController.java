package com.gym.gymapi.workoutsession;

import com.gym.gymapi.workoutsession.dto.WorkoutSessionCreateDTO;
import com.gym.gymapi.workoutsession.dto.WorkoutSessionViewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/workoutSession")
public class WorkoutSessionController {

    @Autowired
    private WorkoutSessionService workoutSessionService;

    @PostMapping
    @ResponseBody
    public WorkoutSessionViewDTO createWorkoutSession(WorkoutSessionCreateDTO workoutSessionCreateDTO) {
        return workoutSessionService.createWorkoutSession(workoutSessionCreateDTO);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public WorkoutSessionViewDTO getWorkoutSession(@PathVariable("id") UUID id) {
        return workoutSessionService.getWorkoutSession(id);
    }

}
