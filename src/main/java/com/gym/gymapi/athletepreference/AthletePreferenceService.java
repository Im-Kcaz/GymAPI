package com.gym.gymapi.athletepreference;

import com.gym.gymapi.athletepreference.dto.AthletePreferenceCreateDTO;
import com.gym.gymapi.athletepreference.dto.AthletePreferenceViewDTO;
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
    public AthletePreferenceViewDTO createAthletePreference(AthletePreferenceCreateDTO athletePreferenceCreateDTO) {
        var athletePreference = athletePreferenceMapper.convertCreateDTOToEntity(athletePreferenceCreateDTO);
        athletePreference = athletePreferenceRepository.save(athletePreference);

        return athletePreferenceMapper.convertEntityToViewDTO(athletePreference);
    }

    @Transactional
    public AthletePreferenceViewDTO getAthletePreference(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("Athlete Preference id cannot be null.");
        }

        var athletePreference = athletePreferenceRepository.findById(id).orElseThrow(NotFoundException::new);

        return athletePreferenceMapper.convertEntityToViewDTO(athletePreference);
    }

}
