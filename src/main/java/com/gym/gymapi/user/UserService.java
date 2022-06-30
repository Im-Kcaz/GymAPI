package com.gym.gymapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;

@Service
public class UserService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    public User addUser(UserDTO userDto) {
        var user = new User();
        user.setEmail(userDto.getEmail());
        user.setUserName(userDto.getUserName());
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
        return user;
    }

    public User getUser(Long id) {
        return userRepository.findById(id)
                             .orElseThrow(NotFoundException::new);
    }

    public Boolean validateUser(UserDTO userDto) {
        var user = userRepository.findUserByEmail(userDto.getEmail())
                                 .orElseThrow(NotFoundException::new);
        return bCryptPasswordEncoder.matches(userDto.getPassword(), user.getPassword());
    }
}
