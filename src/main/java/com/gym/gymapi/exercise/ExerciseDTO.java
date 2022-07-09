package com.gym.gymapi.exercise;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class ExerciseDTO implements Serializable {
    private UUID uuid;
    private String name;
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
