package com.gym.gymapi.athlete;

import com.gym.gymapi.athletepreference.AthletePreference;
import com.gym.gymapi.exerciseblock.ExerciseBlock;
import com.gym.gymapi.user.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@Table(name = "athletes")
public class Athlete {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "binary(36)")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    @OneToOne(mappedBy = "athlete")
    private User user;

    @OneToMany(mappedBy = "athlete")
    @ToString.Exclude
    private List<ExerciseBlock> exerciseBlock;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "athlete_preference_id", referencedColumnName = "id")
    private AthletePreference athletePreference;
}
