package com.gym.gymapi.security;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class Auth0TokenDTO {
    @JsonAlias("access_token")
    private String accessToken;
    private String scope;
    @JsonAlias("expires_in")
    private String expiresIn;
    @JsonAlias("token_type")
    private String tokenType;
}
