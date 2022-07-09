package com.gym.gymapi.exercise;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "uuid")
    private UUID uuid;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private ExerciseType name;

    @Column(name = "sets")
    @Min(value = 1)
    private Integer sets;

    @Column(name = "reps")
    @Min(value = 0)
    private Integer reps;

    @Column(name = "target_weight")
    @Min(value = 0)
    private Float targetWeight;

    @Column(name = "actual_weight")
    @Min(value = 0)
    private Float actualWeight;

    @Column(name = "target_rpe")
    @Min(value = 0)
    @Max(value = 10)
    private Float targetRPE;

    @Column(name = "actual_rpe")
    @Min(value = 0)
    @Max(value = 10)
    private Float actualRPE;

    @Column(name = "pause_time")
    @Min(value = 0)
    private Integer pauseTime;
}
