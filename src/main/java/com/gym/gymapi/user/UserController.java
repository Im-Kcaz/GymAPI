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

import java.util.UUID;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseBody
    public UserDTO createUser(@RequestBody UserDTO userDto) {
        return userService.createUser(userDto);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public UserDTO getUser(@PathVariable("id") UUID id) {
        return userService.getUser(id);
    }

    @PostMapping("/validate")
    public String validateUser(@RequestBody UserDTO userDto, @RequestHeader("authorization") String authorization) {
        return userService.validateUser(userDto);
    }
}
