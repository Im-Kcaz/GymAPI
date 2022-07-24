package com.gym.gymapi.athletepreference;

import com.gym.gymapi.athlete.AthleteDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class AthletePreferenceDTO {
    private UUID id;
    private AthleteDTO athlete;
}
