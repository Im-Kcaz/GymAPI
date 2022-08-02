package com.gym.gymapi.user.dto;

import com.gym.gymapi.athlete.dto.AthleteViewDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class UserViewDTO {
    private UUID id;
    private String email;
    private String firstName;
    private String lastName;
    private String userName;
    private AthleteViewDTO athlete;
}
