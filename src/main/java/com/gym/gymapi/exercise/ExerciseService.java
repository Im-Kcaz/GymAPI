package com.gym.gymapi.exercise;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;

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
        return repository.save(convertDTOToEntity(exerciseDTO));
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
        modelMapper.map(exercise, exerciseDTO);
    }
}
