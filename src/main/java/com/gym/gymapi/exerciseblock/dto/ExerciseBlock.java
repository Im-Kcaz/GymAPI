package com.gym.gymapi.exerciseblock.dto;

import com.gym.gymapi.athlete.dto.Athlete;
import com.gym.gymapi.workoutsession.dto.WorkoutSession;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@Table(name = "exercise_block")
public class ExerciseBlock {

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "athlete_id")
    private Athlete athlete;

    @OneToMany(mappedBy = "exerciseBlock")
    @ToString.Exclude
    private List<WorkoutSession> workoutSessions;
}
