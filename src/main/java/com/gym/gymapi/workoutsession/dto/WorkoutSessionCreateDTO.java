package com.gym.gymapi.workoutsession.dto;

import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
public class WorkoutSessionCreateDTO {
    private Date date;
    private Time time;
}
