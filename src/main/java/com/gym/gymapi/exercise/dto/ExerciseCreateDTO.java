package com.gym.gymapi.exercise.dto;

import lombok.Data;

@Data
public class ExerciseCreateDTO {
    private String exerciseType;
    private Integer sets;
    private Integer reps;
    private Float targetWeight;
    private Float actualWeight;
    private Integer targetReps;
    private Integer actualReps;
    private Float targetRPE;
    private Float actualRPE;
    private Integer pauseTime;
}
