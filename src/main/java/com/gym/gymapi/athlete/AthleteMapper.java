package com.gym.gymapi.athlete;

import com.gym.gymapi.athlete.dto.Athlete;
import com.gym.gymapi.athlete.dto.AthleteCreateDTO;
import com.gym.gymapi.athlete.dto.AthleteViewDTO;
import com.gym.gymapi.user.UserMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AthleteMapper {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ModelMapper modelMapper;

    public Athlete convertCreateDTOToEntity(AthleteCreateDTO athleteCreateDTO) {
        return modelMapper.map(athleteCreateDTO, Athlete.class);
    }

    public AthleteViewDTO convertEntityToViewDTO(Athlete athlete) {
        return modelMapper.map(athlete, AthleteViewDTO.class);
    }
}
