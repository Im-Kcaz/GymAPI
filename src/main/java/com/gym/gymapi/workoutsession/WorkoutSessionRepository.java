package com.gym.gymapi.workoutsession;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WorkoutSessionRepository extends JpaRepository<WorkoutSession, UUID> {
}
