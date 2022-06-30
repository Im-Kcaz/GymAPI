package com.gym.gymapi.exercise;

import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Data
public class ExerciseDTO implements Serializable {
    @Enumerated(EnumType.STRING)
    private ExerciseType name;
    private Float targetWeight;
    private Float actualWeight;
    private Integer targetReps;
    private Integer actualReps;
    private Float targetRPE;
    private Float actualRPE;
    private Integer pauseTime;
}
