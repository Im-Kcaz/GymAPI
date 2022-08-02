package com.gym.gymapi.athletepreference;

import com.gym.gymapi.athletepreference.dto.AthletePreferenceCreateDTO;
import com.gym.gymapi.athletepreference.dto.AthletePreferenceViewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/athletePreference")
@RestController
public class AthletePreferenceController {

    @Autowired
    private AthletePreferenceService athletePreferenceService;

    @PostMapping
    @ResponseBody
    public AthletePreferenceViewDTO createAthletePreference(@RequestBody AthletePreferenceCreateDTO athletePreferenceCreateDTO) {
        return athletePreferenceService.createAthletePreference(athletePreferenceCreateDTO);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public AthletePreferenceViewDTO getAthletePreference(@PathVariable("id") UUID id) {
        return athletePreferenceService.getAthletePreference(id);
    }

}
