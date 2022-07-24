package com.gym.gymapi.exerciseblock;

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
    public ExerciseBlockDTO createExerciseBlock(ExerciseBlockDTO exerciseBlockDTO) {
        if(exerciseBlockDTO == null) {
            throw new IllegalArgumentException("Exercise Block cannot be null.");
        }
        var athleteDTO = exerciseBlockDTO.getAthleteDTO();

        if(athleteDTO == null) {
            throw new IllegalArgumentException("Athlete cannot be null.");
        }

        if(athleteDTO.getId() == null) {
            throw new IllegalArgumentException("Athlete id cannot be null.");
        }

        var exerciseBlock = exerciseBlockMapper.convertDTOToExerciseBlock(exerciseBlockDTO);
        exerciseBlock = exerciseBlockRepository.save(exerciseBlock);

        return exerciseBlockMapper.convertExerciseBlockToDTO(exerciseBlock);
    }

    @Transactional
    public ExerciseBlockDTO getExerciseBlock(UUID id) {
        if(id == null) {
            throw new IllegalArgumentException("Exercise block id cannot be null.");
        }

        var exerciseBlock = exerciseBlockRepository.findById(id)
                                                   .orElseThrow(NotFoundException::new);

        return exerciseBlockMapper.convertExerciseBlockToDTO(exerciseBlock);
    }
}
