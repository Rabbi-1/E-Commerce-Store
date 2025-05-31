package com.fuadrabbi.eommerce_backend.service;

import com.fuadrabbi.eommerce_backend.api.model.LoginBody;
import com.fuadrabbi.eommerce_backend.api.model.RegistrationBody;
import com.fuadrabbi.eommerce_backend.model.dao.LocalUserDAO;
import com.fuadrabbi.eommerce_backend.exception.UserAlreadyExistsException;
import com.fuadrabbi.eommerce_backend.model.LocalUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private LocalUserDAO localUserDAO;
    private EncryptionService encryptionService;
    private JWTService jwtService;

    public UserService(LocalUserDAO localUserDAO, EncryptionService encryptionService, JWTService jwtService) {
        this.localUserDAO = localUserDAO;
        this.encryptionService = encryptionService;
        this.jwtService = jwtService;
    }

    public LocalUser registerUser(RegistrationBody registrationBody) throws UserAlreadyExistsException {
        if (localUserDAO.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()
                || localUserDAO.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException();
        }
        LocalUser user = new LocalUser();
        user.setEmail(registrationBody.getEmail());
        user.setUsername(registrationBody.getUsername());
        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());
        user.setPassword(encryptionService.encryptPassword(registrationBody.getPassword()));
        return localUserDAO.save(user);
    }

    public String loginUser(LoginBody loginBody) {
        Optional<LocalUser> opUser = localUserDAO.findByUsernameIgnoreCase(loginBody.getUsername());
        if(opUser.isPresent()) {
            LocalUser user = opUser.get();
            if(encryptionService.verifyPassword(loginBody.getPassword(), user.getPassword())) {
                return jwtService.generateJWT(user);
            }
        }
        return null;
    }
}

//This UserService class in a Spring Boot application handles user registration and login functionality.
// It interacts with the LocalUserDAO to check if a user already exists and to save new users.
// During registration, it encrypts the password using EncryptionService before storing the user.
// For login, it verifies the user's credentials by checking the password and, if valid, generates a JWT (JSON Web Token)
// using JWTService to authenticate the user. If login fails, it returns null. The service ensures secure handling of user
// credentials and token-based authentication.
