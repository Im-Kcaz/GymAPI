package com.gym.gymapi.exercise;

import com.gym.gymapi.exercise.dto.Exercise;
import com.gym.gymapi.exercise.dto.ExerciseCreateDTO;
import com.gym.gymapi.exercise.dto.ExerciseViewDTO;
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

@RequestMapping("/exercise")
@RestController
public class ExerciseController {

    @Autowired
    private ExerciseService service;

    @PostMapping
    @ResponseBody
    public ExerciseViewDTO createExercise(@RequestBody ExerciseCreateDTO exerciseCreateDTO) {
        return service.createExercise(exerciseCreateDTO);
    }

    @GetMapping
    @ResponseBody
    public List<Exercise> getAllExercises() {
        return service.getAllExercises();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ExerciseViewDTO getExercise(@PathVariable("id") UUID id) {
        return service.getExercise(id);
    }

    @GetMapping("/workout-session/{workoutSessionID}")
    @ResponseBody
    public List<ExerciseViewDTO> getExercisesByWorkoutSession(@PathVariable("workoutSessionId") UUID workoutSessionId) {
        return service.getExercisesByWorkoutSession(workoutSessionId);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ExerciseViewDTO updateExercise(@RequestBody ExerciseViewDTO exerciseDTO,
                                          @PathVariable UUID id) {
        return service.updateExercise(exerciseDTO, id);

    }
}
