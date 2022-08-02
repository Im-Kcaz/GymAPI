package com.gym.gymapi.workoutsession.dto;

import com.gym.gymapi.exercise.dto.Exercise;
import com.gym.gymapi.exerciseblock.dto.ExerciseBlock;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@Table(name = "workout_sessions")
public class WorkoutSession {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "exercise_block_id")
    private ExerciseBlock exerciseBlock;

    @Column
    private Date date;

    @Column
    private Time time;

    @OneToMany(mappedBy = "workoutSession")
    @ToString.Exclude
    private List<Exercise> exercises;

}
