package com.gym.gymapi.athlete;

import com.gym.gymapi.athlete.dto.AthleteCreateDTO;
import com.gym.gymapi.athlete.dto.AthleteViewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/athlete")
@RestController
public class AthleteController {
    @Autowired
    private AthleteService athleteService;

    @PostMapping
    @ResponseBody
    public AthleteViewDTO createAthlete(@RequestBody AthleteCreateDTO athleteCreateDTO) {
        return athleteService.createAthlete(athleteCreateDTO);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public AthleteViewDTO getAthlete(@PathVariable("id") UUID id) {
        return athleteService.getAthlete(id);
    }

}
