package com.gym.gymapi.athletepreference;

import com.gym.gymapi.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.UUID;

@Service
public class AthletePreferenceService {

    @Autowired
    private AthletePreferenceRepository athletePreferenceRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AthletePreferenceMapper athletePreferenceMapper;

    @Transactional
    public AthletePreferenceDTO createAthletePreference(AthletePreferenceDTO athletePreferenceDTO) {
        var athletePreference = athletePreferenceMapper.convertDTOToAthletePreference(athletePreferenceDTO);
        athletePreferenceRepository.save(athletePreference);

        return athletePreferenceMapper.convertAthletePreferenceToDTO(athletePreference);
    }

    @Transactional
    public AthletePreferenceDTO getAthletePreference(UUID id) {
        var athletePreference = athletePreferenceRepository.findById(id).orElseThrow(NotFoundException::new);

        return athletePreferenceMapper.convertAthletePreferenceToDTO(athletePreference);
    }

}
