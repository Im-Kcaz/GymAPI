package com.gym.gymapi.athlete;

import com.gym.gymapi.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AthleteMapper {

    @Autowired
    private UserMapper userMapper;

    public AthleteDTO convertAthleteToDTO(Athlete athlete) {
        if (athlete == null) {
            return null;
        }

        var athleteDTO = new AthleteDTO();
        athleteDTO.setId(athlete.getId());

        var userDTO = userMapper.convertUserToDTO(athlete.getUser());
        athleteDTO.setUser(userDTO);

        return athleteDTO;
    }

    public Athlete convertDTOToAthlete(AthleteDTO athleteDTO) {
        if (athleteDTO == null) {
            return null;
        }

        var athlete = new Athlete();

        var user = userMapper.convertDTOToUser(athleteDTO.getUser());
        athlete.setUser(user);

        return athlete;
    }
}
