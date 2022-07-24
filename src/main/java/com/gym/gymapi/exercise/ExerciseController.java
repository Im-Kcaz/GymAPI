package com.gym.gymapi.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequestMapping("/exercises")
@RestController
public class ExerciseController {

    @Autowired
    private ExerciseService service;

    @PostMapping
    @ResponseBody
    public ExerciseDTO createExercise(@RequestBody ExerciseDTO exerciseDTO) {
        return service.createExercise(exerciseDTO);
    }

    @GetMapping
    @ResponseBody
    public List<Exercise> getAllExercises() {
        return service.getAllExercises();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ExerciseDTO getExercise(@PathVariable("id") UUID id) {
        return service.getExercise(id);
    }

    @GetMapping("/workout-session/{workoutSessionID}")
    @ResponseBody
    public List<ExerciseDTO> getExercisesByWorkoutSession(@PathVariable("workoutSessionId") UUID workoutSessionId) {
        return service.getExercisesByWorkoutSession(workoutSessionId);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ExerciseDTO updateExercise(@RequestBody ExerciseDTO exerciseDTO,
                                      @PathVariable UUID id) {
        return service.updateExercise(exerciseDTO, id);
    }
}
