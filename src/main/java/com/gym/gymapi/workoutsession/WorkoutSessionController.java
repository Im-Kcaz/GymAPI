package com.gym.gymapi.workoutsession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/workoutSessions")
public class WorkoutSessionController {

    @Autowired
    private WorkoutSessionService workoutSessionService;

    @PostMapping
    @ResponseBody
    public WorkoutSessionDTO createWorkoutSession(WorkoutSessionDTO workoutSessionDTO) {
        return workoutSessionService.createWorkoutSession(workoutSessionDTO);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public WorkoutSessionDTO getWorkoutSession(@PathVariable("id") UUID id) {
        return workoutSessionService.getWorkoutSession(id);
    }

}
