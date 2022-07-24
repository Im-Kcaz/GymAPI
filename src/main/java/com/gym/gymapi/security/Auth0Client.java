package com.gym.gymapi.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.stream.Collectors;

@Component
public class Auth0Client {
    private static final String CLIENT_ID = "client_id";
    private static final String CLIENT_SECRET = "client_secret";
    private static final String GRANT_TYPE = "grant_type";
    private static final String AUDIENCE = "audience";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String CONTENT_TYPE_VALUE = "application/x-www-form-urlencoded";

    @Value("${spring.security.oauth2.client.provider.auth0.token-uri}")
    private String tokenURI;

    @Value("${spring.security.oauth2.client.registration.auth0.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.client.registration.auth0.client-secret}")
    private String clientSecret;

    @Value("${spring.security.oauth2.client.provider.auth0.grant-type}")
    private String grantType;

    @Value("${spring.security.oauth2.client.provider.auth0.audience}")
    private String audienceAuth0;

    public Auth0TokenDTO getToken() {
        var parameters = new HashMap<String, String>();
        parameters.put(CLIENT_ID, clientId);
        parameters.put(CLIENT_SECRET, clientSecret);
        parameters.put(GRANT_TYPE, grantType);
        parameters.put(AUDIENCE, audienceAuth0);

        var form = convertToForm(parameters);

        return WebClient.create(tokenURI)
                        .post()
                        .header(CONTENT_TYPE, CONTENT_TYPE_VALUE)
                        .bodyValue(form)
                        .retrieve()
                        .bodyToMono(Auth0TokenDTO.class)
                        .block();
    }

    private String convertToForm(HashMap<String, String> parameters) {
        return parameters.entrySet()
                         .stream()
                         .map(e -> e.getKey() + "=" + URLEncoder.encode(e.getValue(), StandardCharsets.UTF_8))
                         .collect(Collectors.joining("&"));
    }
}
