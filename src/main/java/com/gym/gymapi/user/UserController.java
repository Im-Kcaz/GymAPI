package com.gym.gymapi.user;

import com.gym.gymapi.user.dto.UserCreateDTO;
import com.gym.gymapi.user.dto.UserViewDTO;
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

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseBody
    public UserViewDTO createUser(@RequestBody UserCreateDTO userCreateDTO) {
        return userService.createUser(userCreateDTO);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public UserViewDTO getUser(@PathVariable("id") UUID id) {
        return userService.getUser(id);
    }

    @PostMapping("/validate")
    public String validateUser(@RequestBody UserViewDTO userViewDTO,
                               @RequestHeader("authorization") String authorization) {
        return "";
    }
}
