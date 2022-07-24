package com.gym.gymapi.athlete;

import com.gym.gymapi.user.UserMapper;
import com.gym.gymapi.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class AthleteService {

    @Autowired
    private AthleteRepository athleteRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AthleteMapper athleteMapper;

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public AthleteDTO createAthlete(AthleteDTO athleteDTO) {
        if (athleteDTO == null) {
            throw new IllegalArgumentException("Athlete payload cannot be null.");
        }

        var userDTO = athleteDTO.getUser();

        if (userDTO == null) {
            throw new IllegalArgumentException("User payload cannot be null.");
        }

        if (userDTO.getId() == null) {
            throw new IllegalArgumentException("User id cannot be null.");
        }

        var athlete = athleteMapper.convertDTOToAthlete(athleteDTO);

        var userResultDTO = userService.getUser(userDTO.getId());
        var user = userMapper.convertDTOToUser(userResultDTO);
        athlete.setUser(user);
        athlete = athleteRepository.save(athlete);

        return athleteMapper.convertAthleteToDTO(athlete);
    }

    @Transactional
    public AthleteDTO getAthlete(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("User id cannot be null.");
        }

        var athlete = athleteRepository.findById(id)
                                       .orElseThrow();

        return athleteMapper.convertAthleteToDTO(athlete);
    }

}
