package com.gym.gymapi.exercise;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

class ExerciseServiceTest {

    private ExerciseService exerciseService;

    @Test
    void addExercise() {
        var exerciseRepository = Mockito.mock(ExerciseRepository.class);
        var exercise = new Exercise();
        exercise.setId(1L);
        Mockito.when(exerciseRepository.save(any(Exercise.class)))
               .thenReturn(exercise);

        exerciseService = new ExerciseService(exerciseRepository, new ModelMapper());
        var exerciseResult = exerciseService.addExercise(new ExerciseDTO());
        assertThat(exerciseResult).isNotNull()
                                  .isEqualTo(exercise);
    }

    @Test
    void getAllExercises() {
        var exerciseRepository = Mockito.mock(ExerciseRepository.class);

        var squat = new Exercise();
        squat.setId(1L);

        var exercises = List.of(squat);
        Mockito.when(exerciseRepository.findAll())
               .thenReturn(exercises);

        exerciseService = new ExerciseService(exerciseRepository, new ModelMapper());
        var exercisesResult = exerciseService.getAllExercises();
        assertThat(exercisesResult).contains(squat);
    }

    @Test
    void updateExercise() {
        var exerciseRepository = Mockito.mock(ExerciseRepository.class);
        var exercise = new Exercise();
        exercise.setId(1L);

        Mockito.when(exerciseRepository.findById(anyLong()))
               .thenReturn(Optional.of(exercise));
        Mockito.when(exerciseRepository.save(any(Exercise.class)))
               .thenReturn((exercise));

        exerciseService = new ExerciseService(exerciseRepository, new ModelMapper());
        var exerciseResult = exerciseService.updateExercise(new ExerciseDTO(), 1L);
        assertThat(exerciseResult).isNotNull()
                                  .isEqualTo(exercise);
    }
}
