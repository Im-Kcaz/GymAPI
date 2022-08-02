package com.gym.gymapi.athletepreference.dto;

import com.gym.gymapi.athlete.dto.Athlete;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@Table(name = "athlete_preference")
public class AthletePreference {

    @Id
    @GeneratedValue
    private UUID id;

    @OneToOne(mappedBy = "athletePreference")
    private Athlete athlete;

    @Column(name = "weight_measurement")
    private String weightMeasurement;

    @Column(name = "distance_measurement")
    private String distanceMeasurement;
}
