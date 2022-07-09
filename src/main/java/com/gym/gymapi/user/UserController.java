package com.gym.gymapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseBody
    public User addUser(@RequestBody UserDTO userDto) {
        if (userDto.getEmail() == null) {
            throw new IllegalArgumentException("Email cannot be null.");
        }

        if (userDto.getPassword() == null) {
            throw new IllegalArgumentException("Password cannot be null.");
        }

        return userService.addUser(userDto);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public User getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @PostMapping("/validate")
    public String validateUser(@RequestBody UserDTO userDto, @RequestHeader("authorization") String authorization) {
        if (userDto.getEmail() == null) {
            throw new IllegalArgumentException("Email cannot be null.");
        }

        if (userDto.getPassword() == null) {
            throw new IllegalArgumentException("Password cannot be null.");
        }

        return userService.validateUser(userDto);
    }
}
