package com.gym.gymapi.exerciseblock;

import com.gym.gymapi.exerciseblock.dto.ExerciseBlockCreateDTO;
import com.gym.gymapi.exerciseblock.dto.ExerciseBlockViewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.UUID;

@Service
public class ExerciseBlockService {

    @Autowired
    private ExerciseBlockRepository exerciseBlockRepository;

    @Autowired
    private ExerciseBlockMapper exerciseBlockMapper;

    @Transactional
    public ExerciseBlockViewDTO createExerciseBlock(ExerciseBlockCreateDTO exerciseBlockCreateDTO) {
        if(exerciseBlockCreateDTO == null) {
            throw new IllegalArgumentException("Exercise Block cannot be null.");
        }

        if(exerciseBlockCreateDTO.getAthleteId() == null) {
            throw new IllegalArgumentException("Athlete id cannot be null.");
        }

        var exerciseBlock = exerciseBlockMapper.convertCreateDTOToEntity(exerciseBlockCreateDTO);
        exerciseBlock = exerciseBlockRepository.save(exerciseBlock);

        return exerciseBlockMapper.convertEntityToViewDTO(exerciseBlock);
    }

    @Transactional
    public ExerciseBlockViewDTO getExerciseBlock(UUID id) {
        if(id == null) {
            throw new IllegalArgumentException("Exercise block id cannot be null.");
        }

        var exerciseBlock = exerciseBlockRepository.findById(id)
                                                   .orElseThrow(NotFoundException::new);

        return exerciseBlockMapper.convertEntityToViewDTO(exerciseBlock);
    }
}
