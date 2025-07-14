package com.fuadrabbi.eommerce_backend.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fuadrabbi.eommerce_backend.model.LocalUser;
import jakarta.annotation.PostConstruct;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@NoArgsConstructor
public class JWTService {
    @Value("${jwt.algorithm.key}")
    private String algorithmKey;

    @Value("${jwt.issuer}")
    private String issuer;

    @Value("${jwt.expiryInSeconds}")
    private int expiryInSeconds;

    private Algorithm algorithm;
    private static final String USERNAME_KEY = "USERNAME";
    private static final String EMAIL_KEY = "EMAIL";

    @PostConstruct
    public void postConstruct(){
        algorithm = Algorithm.HMAC256(algorithmKey);
    }
    public String generateJWT(LocalUser user) {
        return JWT.create()
                .withClaim(USERNAME_KEY , user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + (1000* expiryInSeconds)))
                .withIssuer(issuer)
                .sign(algorithm);
    }
    public String generateVerificationJWT(LocalUser user) {
        return JWT.create()
                .withClaim(EMAIL_KEY , user.getEmail())
                .withExpiresAt(new Date(System.currentTimeMillis() + (1000* expiryInSeconds)))
                .withIssuer(issuer)
                .sign(algorithm);
    }
    public String getUsername(String token) {
        return JWT.decode(token).getClaim(USERNAME_KEY).asString();
    }

}
//The JWTService class is responsible for generating and decoding JSON Web Tokens (JWTs) for user authentication.
// It uses configuration values for the secret key (algorithmKey), token issuer, and expiration time, initializing
// the signing algorithm after the object is constructed. The generateJWT method creates a signed token containing
// the user's username, issuer information, and an expiration timestamp. The getUsername method decodes a given JWT to extract
// the stored username claim. This service supports secure, stateless authentication in the application.
