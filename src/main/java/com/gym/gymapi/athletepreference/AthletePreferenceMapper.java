package com.gym.gymapi.athletepreference;

import com.gym.gymapi.athletepreference.dto.AthletePreference;
import com.gym.gymapi.athletepreference.dto.AthletePreferenceCreateDTO;
import com.gym.gymapi.athletepreference.dto.AthletePreferenceViewDTO;
import com.gym.gymapi.user.UserMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AthletePreferenceMapper {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ModelMapper modelMapper;

    public AthletePreferenceViewDTO convertEntityToViewDTO(AthletePreference athletePreference) {
        return modelMapper.map(athletePreference, AthletePreferenceViewDTO.class);
    }

    public AthletePreference convertCreateDTOToEntity(AthletePreferenceCreateDTO athletePreferenceCreateDTO) {
        return modelMapper.map(athletePreferenceCreateDTO, AthletePreference.class);
    }
}
