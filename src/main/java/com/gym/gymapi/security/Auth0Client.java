package com.gym.gymapi.security;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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

    @Value("spring.security.oauth2.client.provider.auth0.token-uri")
    private String tokenURI;

    @Value("spring.security.oauth2.client.registration.auth0.client-id")
    private String clientId;

    @Value("spring.security.oauth2.client.registration.auth0.client-secret")
    private String clientSecret;

    @Value("spring.security.oauth2.client.provider.auth0.grant_type")
    private String grantType;

    @Value("spring.security.oauth2.client.provider.auth0.audience")
    private String audienceAuth0;

    @Autowired
    private ModelMapper modelMapper;

    public Auth0TokenDTO getToken() throws IOException, InterruptedException {
        var parameters = new HashMap<String, String>();
        parameters.put(CLIENT_ID, clientId);
        parameters.put(CLIENT_SECRET, clientSecret);
        parameters.put(GRANT_TYPE, grantType);
        parameters.put(AUDIENCE, audienceAuth0);

        var form = parameters.entrySet()
                             .stream()
                             .map(e -> e.getKey() + "=" + URLEncoder.encode(e.getValue(), StandardCharsets.UTF_8))
                             .collect(Collectors.joining("&"));

        var httpClient = HttpClient.newBuilder()
                                   .build();

        var request = HttpRequest.newBuilder(URI.create(tokenURI))
                                 .headers(CONTENT_TYPE, CONTENT_TYPE_VALUE)
                                 .POST(HttpRequest.BodyPublishers.ofString(form))
                                 .build();

        Auth0TokenDTO responseDto;
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            responseDto = modelMapper.map(response, Auth0TokenDTO.class);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
            throw e;
        }

        return responseDto;
    }
}
