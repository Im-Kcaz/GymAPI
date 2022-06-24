package com.gym.gymapi.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExerciseService {
    @Autowired
    private ExerciseRepository repository;

    @Transactional
    public void addExercise(Exercise exercise) {
        repository.save(exercise);
    }

    @Transactional
    public List<Exercise> getAllExercises() {
        return new ArrayList<>(repository.findAll());
    }
}
