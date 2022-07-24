package com.gym.gymapi.exerciseblock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/exerciseBlocks")
@RestController
public class ExerciseBlockController {

    @Autowired
    private ExerciseBlockService exerciseBlockService;

    @PostMapping
    @ResponseBody
    public ExerciseBlockDTO createExerciseBlock(ExerciseBlockDTO exerciseBlockDTO) {
        return exerciseBlockService.createExerciseBlock(exerciseBlockDTO);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ExerciseBlockDTO getExerciseBlock(@PathVariable("id") UUID id) {
        return exerciseBlockService.getExerciseBlock(id);
    }
}
