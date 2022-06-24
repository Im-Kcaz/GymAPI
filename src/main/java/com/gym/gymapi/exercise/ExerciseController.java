package com.gym.gymapi.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/exercise")
@RestController
public class ExerciseController {

    @Autowired
    private ExerciseService service;

    @PostMapping
    @ResponseBody
    public ExerciseDTO createExercise(@RequestBody ExerciseDTO exercise) {
        if (exercise == null) {
            throw new IllegalArgumentException("Supplied exercise may not be null.");
        }

        var response = new Exercise();
        response.setName(exercise.getName());

        service.addExercise(response);

        var responseDto = new ExerciseDTO();
        responseDto.setName(response.getName());

        return responseDto;
    }

    @GetMapping
    @ResponseBody
    public List<Exercise> getAllExercises() {
        return service.getAllExercises();
    }
}
