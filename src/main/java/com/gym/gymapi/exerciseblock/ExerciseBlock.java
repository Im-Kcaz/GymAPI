package com.gym.gymapi.exerciseblock;

import com.gym.gymapi.athlete.Athlete;
import com.gym.gymapi.workoutsession.WorkoutSession;
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
@Table(name = "exercise_blocks")
public class ExerciseBlock {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "binary(36)")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "athlete_id")
    private Athlete athlete;

    @OneToMany(mappedBy = "exerciseBlock")
    @ToString.Exclude
    private List<WorkoutSession> workoutSessions;
}
