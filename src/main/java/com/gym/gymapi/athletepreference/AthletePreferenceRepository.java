package com.gym.gymapi.athletepreference;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AthletePreferenceRepository extends JpaRepository<AthletePreference, UUID> {
}
