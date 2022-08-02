package com.gym.gymapi.exerciseblock.dto;

import com.gym.gymapi.athlete.dto.AthleteViewDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class ExerciseBlockViewDTO {
    private UUID id;
    private AthleteViewDTO athlete;
}
