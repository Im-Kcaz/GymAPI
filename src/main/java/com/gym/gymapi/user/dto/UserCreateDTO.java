package com.gym.gymapi.user.dto;

import lombok.Data;

@Data
public class UserCreateDTO {
    private String email;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
}
