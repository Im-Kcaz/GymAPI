package com.gym.gymapi.exercise;

import com.gym.gymapi.exercise.dto.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, UUID> {

    @Query(value = "SELECT * FROM exercises e WHERE e.workout_session_id = ?1", nativeQuery = true)
    List<Exercise> findByWorkoutSessionId(UUID id);

}
