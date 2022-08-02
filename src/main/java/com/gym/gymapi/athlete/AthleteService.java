package com.gym.gymapi.athlete;

import com.gym.gymapi.athlete.dto.AthleteCreateDTO;
import com.gym.gymapi.athlete.dto.AthleteViewDTO;
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
    public AthleteViewDTO createAthlete(AthleteCreateDTO athleteCreateDTO) {
        if (athleteCreateDTO == null) {
            throw new IllegalArgumentException("Athlete payload cannot be null.");
        }

        if (athleteCreateDTO.getUserId() == null) {
            throw new IllegalArgumentException("User id cannot be null.");
        }

        var athlete = athleteMapper.convertCreateDTOToEntity(athleteCreateDTO);

        var userResultDTO = userService.getUser(athleteCreateDTO.getUserId());
        var user = userMapper.convertViewDTOToEntity(userResultDTO);
        athlete.setUser(user);
        athlete = athleteRepository.save(athlete);

        return athleteMapper.convertEntityToViewDTO(athlete);
    }

    @Transactional
    public AthleteViewDTO getAthlete(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("User id cannot be null.");
        }

        var athlete = athleteRepository.findById(id)
                                       .orElseThrow();

        return athleteMapper.convertEntityToViewDTO(athlete);
    }

}
