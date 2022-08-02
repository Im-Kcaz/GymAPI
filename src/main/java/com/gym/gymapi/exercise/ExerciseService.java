package com.gym.gymapi.exercise;

import com.gym.gymapi.exercise.dto.Exercise;
import com.gym.gymapi.exercise.dto.ExerciseCreateDTO;
import com.gym.gymapi.exercise.dto.ExerciseViewDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.UUID;

@Service
@Data
@AllArgsConstructor
public class ExerciseService {

    @Autowired
    private ExerciseRepository repository;

    @Autowired
    private ExerciseMapper exerciseMapper;

    @Transactional
    public ExerciseViewDTO createExercise(ExerciseCreateDTO exerciseCreateDTO) {
        if (exerciseCreateDTO == null) {
            throw new IllegalArgumentException("Exercise cannot be null.");
        }

        var exercise = exerciseMapper.convertCreateDTOToEntity(exerciseCreateDTO);
        exercise = repository.save(exercise);

        return exerciseMapper.convertEntityToViewDTO(exercise);
    }

    @Transactional
    public List<Exercise> getAllExercises() {
        return repository.findAll();
    }

    @Transactional
    public ExerciseViewDTO getExercise(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("Exercise id cannot be null.");
        }

        var exercise = repository.findById(id)
                                 .orElseThrow(NotFoundException::new);

        return exerciseMapper.convertEntityToViewDTO(exercise);
    }

    @Transactional
    public List<ExerciseViewDTO> getExercisesByWorkoutSession(UUID workoutSessionId) {
        if (workoutSessionId == null) {
            throw new IllegalArgumentException("Workout Session id cannot be null.");
        }

        var exercises = repository.findByWorkoutSessionId(workoutSessionId);

        return exercises.stream()
                        .map(exercise -> exerciseMapper.convertEntityToViewDTO(exercise))
                        .toList();
    }

    @Transactional
    public ExerciseViewDTO updateExercise(ExerciseViewDTO exerciseDTO, UUID id) {
        if (exerciseDTO == null) {
            throw new IllegalArgumentException("Exercise cannot be null.");
        }

        if (id == null) {
            throw new IllegalArgumentException("Exercise id cannot be null.");
        }

        var exercise = repository.findById(id)
                                 .orElseThrow(NotFoundException::new);

        updateEntityFromDTO(exerciseDTO, exercise);

        exercise = repository.save(exercise);

        return exerciseMapper.convertEntityToViewDTO(exercise);
    }

    private void updateEntityFromDTO(ExerciseViewDTO exerciseDTO, Exercise exercise) {
        exercise.setExerciseType(ExerciseType.valueOf(exerciseDTO.getExerciseType()));
        exercise.setReps(exerciseDTO.getReps());
        exercise.setSets(exerciseDTO.getSets());
        exercise.setTargetWeight(exerciseDTO.getTargetWeight());
        exercise.setActualWeight(exerciseDTO.getActualWeight());
        exercise.setTargetRPE(exerciseDTO.getTargetRPE());
        exercise.setActualRPE(exerciseDTO.getActualRPE());
        exercise.setPauseTime(exerciseDTO.getPauseTime());
    }
}
