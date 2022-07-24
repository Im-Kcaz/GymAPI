package com.gym.gymapi.exerciseblock;

import com.gym.gymapi.athlete.AthleteDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class ExerciseBlockDTO {
    private UUID id;
    private AthleteDTO athleteDTO;
}
