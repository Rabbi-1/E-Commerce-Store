package com.fuadrabbi.eommerce_backend.service;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;


@Service
public class EncryptionService {
    @Value("${encryption.salt.rounds}")
    private int saltRounds;
    private String salt;

    @PostConstruct
    public void postConstruct() {
        salt = BCrypt.gensalt(saltRounds);
    }

    public String encryptPassword(String password) {
        return BCrypt.hashpw(password, salt);
    }

    public boolean verifyPassword(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }
}

//The EncryptionService class handles password encryption and verification using BCrypt.
// It generates a salt during initialization and uses it to securely hash passwords, as well as to verify
// if a given password matches a stored hash.