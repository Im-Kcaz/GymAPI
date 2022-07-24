package com.gym.gymapi.athletepreference;

import com.gym.gymapi.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AthletePreferenceMapper {

    @Autowired
    private UserMapper userMapper;

    public AthletePreferenceDTO convertAthletePreferenceToDTO(AthletePreference athletePreference) {
        if(athletePreference == null) {
            return null;
        }

        var athletePreferenceDTO = new AthletePreferenceDTO();
        athletePreferenceDTO.setId(athletePreference.getId());

        return athletePreferenceDTO;
    }

    public AthletePreference convertDTOToAthletePreference(AthletePreferenceDTO athletePreferenceDTO) {
        if(athletePreferenceDTO == null) {
            return null;
        }

        return new AthletePreference();
    }
}
