package com.gym.gymapi.exercise;

import com.gym.gymapi.exercise.dto.Exercise;
import com.gym.gymapi.exercise.dto.ExerciseCreateDTO;
import com.gym.gymapi.exercise.dto.ExerciseViewDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExerciseMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ExerciseViewDTO convertEntityToViewDTO(Exercise exercise) {
        return modelMapper.map(exercise, ExerciseViewDTO.class);
    }

    public Exercise convertCreateDTOToEntity(ExerciseCreateDTO exerciseCreateDTO) {
        return modelMapper.map(exerciseCreateDTO, Exercise.class);
    }

    public Exercise convertViewDTOToEntity(ExerciseViewDTO exerciseViewDTO) {
        return modelMapper.map(exerciseViewDTO, Exercise.class);
    }
}
