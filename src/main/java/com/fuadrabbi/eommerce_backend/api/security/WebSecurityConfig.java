package com.fuadrabbi.eommerce_backend.api.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;

@Configuration
public class WebSecurityConfig {
    private final JWTRequestFilter jwtRequestFilter;

    public WebSecurityConfig(JWTRequestFilter jwtRequestFilter) {
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .addFilterBefore(jwtRequestFilter, AuthorizationFilter.class)
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/product", "/auth/register", "/auth/login").permitAll()
                        .anyRequest().authenticated()
                )
                .build();
    }
}
// The WebSecurityConfig class sets up the security rules for the application using Spring Security.
// It disables CSRF and CORS and injects a custom JWTRequestFilter
// that checks for valid JWT tokens in incoming requests.
// Public access is allowed to the /product, /auth/register, and /auth/login endpoints.
// All other endpoints require authentication.
// This configuration ensures that only authenticated users can access protected resources, while still
// allowing unauthenticated users to register or log in.
