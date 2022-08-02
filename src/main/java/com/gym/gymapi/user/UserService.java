package com.gym.gymapi.user;

import com.gym.gymapi.user.dto.UserCreateDTO;
import com.gym.gymapi.user.dto.UserViewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public UserViewDTO createUser(UserCreateDTO userCreateDTO) {
        if (userCreateDTO.getEmail() == null) {
            throw new IllegalArgumentException("Email cannot be null.");
        }

        if (userCreateDTO.getPassword() == null) {
            throw new IllegalArgumentException("Password cannot be null.");
        }

        var user = userMapper.convertCreateDTOToEntity(userCreateDTO);

        user.setPassword(bCryptPasswordEncoder.encode(userCreateDTO.getPassword()));
        user = userRepository.save(user);

        return userMapper.convertEntityToViewDTO(user);
    }

    @Transactional
    public UserViewDTO getUser(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("User id cannot be null.");
        }

        var user = userRepository.findById(id)
                                 .orElseThrow(NotFoundException::new);

        return userMapper.convertEntityToViewDTO(user);
    }

    public String validateUser(UserCreateDTO userDto) {
        if (userDto.getEmail() == null) {
            throw new IllegalArgumentException("Email cannot be null.");
        }

        if (userDto.getPassword() == null) {
            throw new IllegalArgumentException("Password cannot be null.");
        }

        var user = userRepository.findUserByEmail(userDto.getEmail())
                                 .orElseThrow(NotFoundException::new);
        final var isValidUser = bCryptPasswordEncoder.matches(userDto.getPassword(), user.getPassword());

        return String.valueOf(isValidUser);
    }
}
