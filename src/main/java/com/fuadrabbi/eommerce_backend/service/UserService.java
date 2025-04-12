package com.fuadrabbi.eommerce_backend.service;

import com.fuadrabbi.eommerce_backend.api.model.RegistrationBody;
import com.fuadrabbi.eommerce_backend.api.model.dao.LocalUserDAO;
import com.fuadrabbi.eommerce_backend.model.LocalUser;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private LocalUserDAO localUserDAO;
    public UserService(LocalUserDAO localUserDAO) {
        this.localUserDAO = localUserDAO;
    }

    public LocalUser registerUser(RegistrationBody registrationBody) {
        LocalUser user = new LocalUser();
        user.setEmail(registrationBody.getEmail());
        user.setUsername(registrationBody.getUsername());
        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());
        //TODO: Encrypt password
        user.setPassword(registrationBody.getPassword());
        user = localUserDAO.save(user);
        return user;
    }
}
