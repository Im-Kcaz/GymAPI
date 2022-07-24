package com.gym.gymapi.workoutsession;

import com.gym.gymapi.exercise.Exercise;
import com.gym.gymapi.exerciseblock.ExerciseBlock;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.UUID;

@Data
public class WorkoutSessionDTO {
    private UUID id;
    private ExerciseBlock exerciseBlock;
    private Date date;
    private Time time;
    private List<Exercise> exercises;
}
