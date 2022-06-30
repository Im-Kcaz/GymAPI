package com.gym.gymapi.user;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
}
