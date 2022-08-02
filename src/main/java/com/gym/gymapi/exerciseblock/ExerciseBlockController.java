package com.gym.gymapi.exerciseblock;

import com.gym.gymapi.exerciseblock.dto.ExerciseBlockCreateDTO;
import com.gym.gymapi.exerciseblock.dto.ExerciseBlockViewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/exerciseBlock")
@RestController
public class ExerciseBlockController {

    @Autowired
    private ExerciseBlockService exerciseBlockService;

    @PostMapping
    @ResponseBody
    public ExerciseBlockViewDTO createExerciseBlock(ExerciseBlockCreateDTO exerciseBlockCreateDTO) {
        return exerciseBlockService.createExerciseBlock(exerciseBlockCreateDTO);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ExerciseBlockViewDTO getExerciseBlock(@PathVariable("id") UUID id) {
        return exerciseBlockService.getExerciseBlock(id);
    }
}
