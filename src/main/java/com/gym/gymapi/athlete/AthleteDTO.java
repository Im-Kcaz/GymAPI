package com.gym.gymapi.athlete;

import com.gym.gymapi.user.UserDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class AthleteDTO {
    private UUID id;
    private UserDTO user;
}
