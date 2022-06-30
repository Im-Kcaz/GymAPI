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

import javax.ws.rs.NotFoundException;
import java.util.List;

@RequestMapping("/exercise")
@RestController
public class ExerciseController {

    @Autowired
    private ExerciseService service;

    @PostMapping
    @ResponseBody
    public Exercise createExercise(@RequestBody ExerciseDTO exerciseDTO) {
        if (exerciseDTO == null) {
            throw new IllegalArgumentException("Supplied exercise may not be null.");
        }

        return service.addExercise(exerciseDTO);
    }

    @GetMapping
    @ResponseBody
    public List<Exercise> getAllExercises() {
        return service.getAllExercises();
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Exercise updateExercise(@RequestBody ExerciseDTO exerciseDTO,
                                   @PathVariable Long id) throws NotFoundException {
        if (exerciseDTO == null) {
            throw new IllegalArgumentException("Supplied exercise may not be null.");
        }

        if (id == null) {
            throw new IllegalArgumentException("Supplied id may not be null.");
        }

        return service.updateExercise(exerciseDTO, id);
    }
}
