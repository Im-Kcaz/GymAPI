package com.gym.gymapi.athletepreference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/athletePreferences")
@RestController
public class AthletePreferenceController {

    @Autowired
    private AthletePreferenceService athletePreferenceService;

    @PostMapping
    @ResponseBody
    public AthletePreferenceDTO createAthletePreference(@RequestBody AthletePreferenceDTO athletePreferenceDTO) {
        return athletePreferenceService.createAthletePreference(athletePreferenceDTO);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public AthletePreferenceDTO getAthletePreference(@PathVariable("id") UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("Athlete Preference id cannot be null.");
        }

        return athletePreferenceService.getAthletePreference(id);
    }

}
