package com.gym.gymapi.user;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO convertUserToDTO(User user) {
        if(user == null) {
            return null;
        }

        var dto = new UserDTO();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setUserName(user.getUserName());

        return dto;
    }

    public User convertDTOToUser(UserDTO userDTO) {
        if(userDTO == null) {
            return null;
        }

        var user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setUserName(userDTO.getUserName());

        return user;
    }
}
