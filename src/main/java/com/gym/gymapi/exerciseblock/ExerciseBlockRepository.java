package com.gym.gymapi.exerciseblock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExerciseBlockRepository extends JpaRepository<ExerciseBlock, UUID> {
}
