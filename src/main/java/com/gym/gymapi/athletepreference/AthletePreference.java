package com.gym.gymapi.athletepreference;

import com.gym.gymapi.athlete.Athlete;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

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
@Table(name = "athlete_preferences")
public class AthletePreference {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "binary(36)")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    @OneToOne(mappedBy = "athletePreference")
    private Athlete athlete;

    @Column(name = "weight_measurement")
    private String weightMeasurement;

    @Column(name = "distance_measurement")
    private String distanceMeasurement;
}
