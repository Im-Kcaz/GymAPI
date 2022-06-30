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

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private ExerciseType name;

    @Column(name = "target_weight")
    @Min(value = 0)
    private Float targetWeight;

    @Column(name = "actual_weight")
    @Min(value = 0)
    private Float actualWeight;

    @Column(name = "target_reps")
    @Min(value = 0)
    private Integer targetReps;

    @Column(name = "actual_reps")
    @Min(value = 0)
    private Integer actualReps;

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
