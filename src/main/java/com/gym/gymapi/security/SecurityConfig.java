package com.gym.gymapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String READ_USERS_SCOPE = "SCOPE_read:users";

    private static final String PATH_START = "/";
    private static final String EXERCISE_PATH = PATH_START + "exercise";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
            .and()
            .authorizeRequests()
            .antMatchers(HttpMethod.GET, EXERCISE_PATH)
            .hasAuthority(READ_USERS_SCOPE)
            .antMatchers(HttpMethod.POST, EXERCISE_PATH)
            .hasAuthority(READ_USERS_SCOPE)
            .antMatchers(HttpMethod.PUT, EXERCISE_PATH)
            .hasAuthority(READ_USERS_SCOPE)
            .and()
            .oauth2ResourceServer()
            .jwt();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("*"));
        //or any domain that you want to restrict to
        configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
        //Add the method support as you like
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
