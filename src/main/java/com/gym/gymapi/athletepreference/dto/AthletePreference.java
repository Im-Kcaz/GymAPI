package com.gym.gymapi.athletepreference.dto;

import com.gym.gymapi.athlete.dto.Athlete;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "athlete_preference_id", referencedColumnName = "id")
    private Athlete athlete;

    @Column(name = "weight_measurement")
    private String weightMeasurement;

    @Column(name = "distance_measurement")
    private String distanceMeasurement;
}
