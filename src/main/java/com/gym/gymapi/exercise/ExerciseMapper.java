package com.gym.gymapi.exercise;

import org.springframework.stereotype.Component;

@Component
public class ExerciseMapper {

    public ExerciseDTO convertExerciseToDTO(Exercise exercise) {
        if (exercise == null) {
            return null;
        }

        var exerciseDTO = new ExerciseDTO();
        exerciseDTO.setId(exercise.getId());
        exerciseDTO.setExerciseType(exercise.getExerciseType().toString());
        exerciseDTO.setReps(exercise.getReps());
        exerciseDTO.setSets(exercise.getSets());
        exerciseDTO.setTargetWeight(exercise.getTargetWeight());
        exerciseDTO.setActualWeight(exercise.getActualWeight());
        exerciseDTO.setTargetRPE(exercise.getTargetRPE());
        exerciseDTO.setActualRPE(exercise.getActualRPE());
        exerciseDTO.setPauseTime(exercise.getPauseTime());

        return exerciseDTO;
    }

    public Exercise convertDTOToExercise(ExerciseDTO exerciseDTO) {
        if (exerciseDTO == null) {
            return null;
        }

        var exercise = new Exercise();
        exercise.setExerciseType(ExerciseType.valueOf(exerciseDTO.getExerciseType()));
        exercise.setReps(exerciseDTO.getReps());
        exercise.setSets(exerciseDTO.getSets());
        exercise.setTargetWeight(exerciseDTO.getTargetWeight());
        exercise.setActualWeight(exerciseDTO.getActualWeight());
        exercise.setTargetRPE(exerciseDTO.getTargetRPE());
        exercise.setActualRPE(exerciseDTO.getActualRPE());
        exercise.setPauseTime(exerciseDTO.getPauseTime());

        return exercise;
    }
}
