package com.gym.gymapi.exerciseblock;

import com.gym.gymapi.athlete.AthleteMapper;
import com.gym.gymapi.athlete.dto.Athlete;
import com.gym.gymapi.exerciseblock.dto.ExerciseBlock;
import com.gym.gymapi.exerciseblock.dto.ExerciseBlockCreateDTO;
import com.gym.gymapi.exerciseblock.dto.ExerciseBlockViewDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExerciseBlockMapper {

    @Autowired
    private AthleteMapper athleteMapper;

    @Autowired
    private ModelMapper modelMapper;

    public ExerciseBlockViewDTO convertEntityToViewDTO(ExerciseBlock exerciseBlock) {
        if (exerciseBlock == null) {
            return null;
        }

        var exerciseBlockDTO = new ExerciseBlockViewDTO();
        exerciseBlockDTO.setId(exerciseBlock.getId());

        return exerciseBlockDTO;
    }

    public ExerciseBlock convertViewDTOToEntity(ExerciseBlockViewDTO exerciseBlockDTO) {
        if (exerciseBlockDTO == null) {
            return null;
        }

        var exerciseBlock = new ExerciseBlock();

        var athlete = new Athlete();
        exerciseBlock.setAthlete(athlete);

        return exerciseBlock;
    }

    public ExerciseBlock convertCreateDTOToEntity(ExerciseBlockCreateDTO exerciseBlockCreateDTO) {
        return modelMapper.map(exerciseBlockCreateDTO, ExerciseBlock.class);
    }
}
