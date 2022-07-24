package com.gym.gymapi.athlete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/athletes")
@RestController
public class AthleteController {
    @Autowired
    private AthleteService athleteService;

    @PostMapping
    @ResponseBody
    public AthleteDTO createAthlete(@RequestBody AthleteDTO athleteDTO) {
        return athleteService.createAthlete(athleteDTO);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public AthleteDTO getAthlete(@PathVariable("id") UUID id) {
        return athleteService.getAthlete(id);
    }

}
