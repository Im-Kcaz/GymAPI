package com.gym.gymapi.exerciseblock;

import com.gym.gymapi.athlete.Athlete;
import com.gym.gymapi.athlete.AthleteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExerciseBlockMapper {

    @Autowired
    private AthleteMapper athleteMapper;

    public ExerciseBlockDTO convertExerciseBlockToDTO(ExerciseBlock exerciseBlock) {
        if (exerciseBlock == null) {
            return null;
        }

        var exerciseBlockDTO = new ExerciseBlockDTO();
        exerciseBlockDTO.setId(exerciseBlock.getId());

        var athleteDTO = athleteMapper.convertAthleteToDTO(exerciseBlock.getAthlete());
        exerciseBlockDTO.setAthleteDTO(athleteDTO);

        return exerciseBlockDTO;
    }

    public ExerciseBlock convertDTOToExerciseBlock(ExerciseBlockDTO exerciseBlockDTO) {
        if (exerciseBlockDTO == null) {
            return null;
        }

        var exerciseBlock = new ExerciseBlock();

        var athlete = new Athlete();
        exerciseBlock.setAthlete(athlete);

        return exerciseBlock;
    }
}
