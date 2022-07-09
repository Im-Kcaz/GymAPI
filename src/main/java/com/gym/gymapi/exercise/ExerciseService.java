package com.gym.gymapi.exercise;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.UUID;

@Service
@Data
@AllArgsConstructor
public class ExerciseService {

    @Autowired
    private ExerciseRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public Exercise addExercise(ExerciseDTO exerciseDTO) {
        var exercise = convertDTOToEntity(exerciseDTO);
        exercise.setUuid(UUID.randomUUID());
        return repository.save(exercise);
    }

    @Transactional
    public List<Exercise> getAllExercises() {
        return repository.findAll();
    }

    @Transactional
    public Exercise updateExercise(ExerciseDTO exerciseDTO, Long id) throws NotFoundException {
        var exercise = repository.findById(id)
                                 .orElseThrow(NotFoundException::new);

        updateEntityFromDTO(exerciseDTO, exercise);

        return repository.save(exercise);
    }

    private Exercise convertDTOToEntity(ExerciseDTO exerciseDTO) {
        var exercise = new Exercise();

        updateEntityFromDTO(exerciseDTO, exercise);

        return exercise;
    }

    private void updateEntityFromDTO(ExerciseDTO exerciseDTO, Exercise exercise) {
        exercise.setName(ExerciseType.valueOf(exerciseDTO.getName()));
        exercise.setReps(exerciseDTO.getReps());
        exercise.setSets(exerciseDTO.getSets());
        exercise.setTargetWeight(exerciseDTO.getTargetWeight());
        exercise.setActualWeight(exerciseDTO.getActualWeight());
        exercise.setTargetRPE(exerciseDTO.getTargetRPE());
        exercise.setActualRPE(exerciseDTO.getActualRPE());
        exercise.setPauseTime(exerciseDTO.getPauseTime());
    }
}
