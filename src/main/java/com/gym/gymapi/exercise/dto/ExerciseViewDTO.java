package com.gym.gymapi.exercise.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class ExerciseViewDTO implements Serializable {
    private UUID id;
    private String exerciseType;
    private Integer sets;
    private Integer reps;
    private Float targetWeight;
    private Float actualWeight;
    private Float targetRPE;
    private Float actualRPE;
    private Integer pauseTime;
}
