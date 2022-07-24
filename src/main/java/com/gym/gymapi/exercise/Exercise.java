package com.gym.gymapi.exercise;

import com.gym.gymapi.workoutsession.WorkoutSession;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@Table(name = "exercises", indexes = @Index(columnList = "workout_session_id"))
public class Exercise {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "binary(36)")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    @Column(name = "exercise_type")
    @Enumerated(EnumType.STRING)
    private ExerciseType exerciseType;

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

    @ManyToOne
    @JoinColumn(name = "workout_session_id")
    private WorkoutSession workoutSession;

}
