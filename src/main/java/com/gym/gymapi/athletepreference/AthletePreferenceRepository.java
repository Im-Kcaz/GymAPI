package com.gym.gymapi.athletepreference;

import com.gym.gymapi.athletepreference.dto.AthletePreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AthletePreferenceRepository extends JpaRepository<AthletePreference, UUID> {
}
