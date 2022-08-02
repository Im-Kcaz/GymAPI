package com.gym.gymapi.athlete.dto;

import com.gym.gymapi.athletepreference.dto.AthletePreference;
import com.gym.gymapi.exerciseblock.dto.ExerciseBlock;
import com.gym.gymapi.user.dto.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@Table(name = "athlete")
public class Athlete {

    @Id
    @GeneratedValue
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "athlete")
    @ToString.Exclude
    private List<ExerciseBlock> exerciseBlock;

    @OneToOne
    @JoinColumn(name = "athlete_preference_id", referencedColumnName = "id")
    private AthletePreference athletePreference;
}
