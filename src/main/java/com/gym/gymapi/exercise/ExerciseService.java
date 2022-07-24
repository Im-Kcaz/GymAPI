package com.gym.gymapi.exercise;

import lombok.AllArgsConstructor;
import lombok.Data;

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
    public ExerciseDTO createExercise(ExerciseDTO exerciseDTO) {
        if (exerciseDTO == null) {
            throw new IllegalArgumentException("Exercise cannot be null.");
        }

        var exercise = exerciseMapper.convertDTOToExercise(exerciseDTO);
        exercise = repository.save(exercise);

        return exerciseMapper.convertExerciseToDTO(exercise);
    }

    @Transactional
    public List<Exercise> getAllExercises() {
        return repository.findAll();
    }

    @Transactional
    public ExerciseDTO getExercise(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("Exercise id cannot be null.");
        }

        var exercise = repository.findById(id)
                                 .orElseThrow(NotFoundException::new);

        return exerciseMapper.convertExerciseToDTO(exercise);
    }

    @Transactional
    public List<ExerciseDTO> getExercisesByWorkoutSession(UUID workoutSessionId) {
        if (workoutSessionId == null) {
            throw new IllegalArgumentException("Workout Session id cannot be null.");
        }

        var exercises = repository.findByWorkoutSessionId(workoutSessionId);

        return exercises.stream()
                        .map(exercise -> exerciseMapper.convertExerciseToDTO(exercise))
                        .toList();
    }

    @Transactional
    public ExerciseDTO updateExercise(ExerciseDTO exerciseDTO, UUID id) {
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

        return exerciseMapper.convertExerciseToDTO(exercise);
    }

    private void updateEntityFromDTO(ExerciseDTO exerciseDTO, Exercise exercise) {
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
