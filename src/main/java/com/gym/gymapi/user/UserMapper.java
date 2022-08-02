package com.gym.gymapi.user;

import com.gym.gymapi.user.dto.User;
import com.gym.gymapi.user.dto.UserCreateDTO;
import com.gym.gymapi.user.dto.UserViewDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    ModelMapper modelMapper;

    public UserViewDTO convertEntityToViewDTO(User user) {
        return modelMapper.map(user, UserViewDTO.class);
    }

    public User convertCreateDTOToEntity(UserCreateDTO userCreateDTO) {
        return modelMapper.typeMap(UserCreateDTO.class, User.class)
                          .addMappings(mapping -> mapping.skip(User::setPassword))
                          .map(userCreateDTO);
    }

    public User convertViewDTOToEntity(UserViewDTO userViewDTO) {
        return modelMapper.map(userViewDTO, User.class);
    }
}
