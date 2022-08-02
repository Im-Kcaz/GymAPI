package com.gym.gymapi.athletepreference.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class AthletePreferenceCreateDTO {
    private UUID athleteId;
    private String weightMeasurement;
    private String distanceMeasurement;
}
