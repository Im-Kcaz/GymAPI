package com.gym.gymapi.security;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/authorization")
@RestController
public class AuthorizationController {

    @Autowired
    private Auth0Client auth0Client;

    @SneakyThrows
    @GetMapping
    @ResponseBody
    public Auth0TokenDTO getAuthToken() {
        return auth0Client.getToken();
    }
}
