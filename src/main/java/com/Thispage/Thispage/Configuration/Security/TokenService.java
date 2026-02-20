package com.Thispage.Thispage.Configuration.Security;

import com.Thispage.Thispage.Domain.Credentials;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token}")
    private String secretKey;

    public String generateToken(Credentials credentials) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            String token = JWT.create()
                    .withIssuer("logi-auth-api")
                    .withSubject(credentials.getEmail())
                    .withExpiresAt(generateExcpetionDate())
                    .sign(algorithm);
            return token;
        }
        catch (JWTCreationException exception) {
            throw new RuntimeException("Error while authentication");
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            String email = JWT.require(algorithm)
                    .withIssuer("logi-auth-api")
                    .build()
                    .verify(token)
                    .getSubject();
            return email;
        }
        catch (JWTVerificationException exception) {
            return null;
        }
    }

    private Instant generateExcpetionDate() {
        return LocalDateTime.now()
                .plusHours(2)
                .toInstant(ZoneOffset.of("-03:00"));
    }
}
