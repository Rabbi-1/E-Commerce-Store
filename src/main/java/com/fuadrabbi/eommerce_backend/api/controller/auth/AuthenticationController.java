package com.fuadrabbi.eommerce_backend.api.controller;

import com.fuadrabbi.eommerce_backend.api.model.LoginBody;
import com.fuadrabbi.eommerce_backend.api.model.LoginResponse;
import com.fuadrabbi.eommerce_backend.api.model.RegistrationBody;
import com.fuadrabbi.eommerce_backend.exception.UserAlreadyExistsException;
import com.fuadrabbi.eommerce_backend.model.LocalUser;
import com.fuadrabbi.eommerce_backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@Valid @RequestBody RegistrationBody registrationBody) {
        try {
            userService.registerUser(registrationBody);
            return ResponseEntity.ok().build();
        } catch (UserAlreadyExistsException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@Valid @RequestBody LoginBody loginBody) {
        String jwt = userService.loginUser(loginBody);
        if (jwt == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setJwt(jwt);
            return ResponseEntity.ok(loginResponse);
        }
    }
    @GetMapping("/me")
    public LocalUser getLoggedInUserProfile(@AuthenticationPrincipal LocalUser user) {
        return user;
    }
}
//The AuthenticationController handles user registration, login, and profile retrieval.
// It exposes API endpoints to register a new user, authenticate a user and return a JWT, and retrieve
// the profile of the currently logged-in user. It delegates user-related operations to the
// UserService and returns appropriate HTTP responses based on the outcome.