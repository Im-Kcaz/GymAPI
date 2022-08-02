package com.gym.gymapi.workoutsession.dto;

import com.gym.gymapi.exercise.dto.Exercise;
import com.gym.gymapi.exerciseblock.dto.ExerciseBlock;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.UUID;

@Data
public class WorkoutSessionViewDTO {
    private UUID id;
    private ExerciseBlock exerciseBlock;
    private Date date;
    private Time time;
    private List<Exercise> exercises;
}
