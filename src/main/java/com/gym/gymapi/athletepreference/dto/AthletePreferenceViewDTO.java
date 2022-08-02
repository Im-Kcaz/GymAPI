package com.gym.gymapi.athletepreference.dto;

import com.gym.gymapi.athlete.dto.AthleteViewDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class AthletePreferenceViewDTO {
    private UUID id;
    private AthleteViewDTO athlete;
    private String weightMeasurement;
    private String distanceMeasurement;
}
