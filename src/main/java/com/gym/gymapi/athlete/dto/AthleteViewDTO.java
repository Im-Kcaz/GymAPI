package com.gym.gymapi.athlete.dto;

import com.gym.gymapi.user.dto.UserViewDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class AthleteViewDTO {
    private UUID id;
    private UserViewDTO user;
}
