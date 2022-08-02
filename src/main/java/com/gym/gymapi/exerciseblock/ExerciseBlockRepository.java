package com.gym.gymapi.exerciseblock;

import com.gym.gymapi.exerciseblock.dto.ExerciseBlock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExerciseBlockRepository extends JpaRepository<ExerciseBlock, UUID> {
}
