package com.dtopiast.venus.infraestructure.service.auth;

import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.dtopiast.venus.core.service.auth.ITokenService;
import com.dtopiast.venus.domain.role.model.Role;
import com.dtopiast.venus.domain.user.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.stream.Collectors;

@Service
public class TokenService implements ITokenService {

    private static final ZoneOffset ZONE_OFFSET = ZoneOffset.of("-05:00");
    @Value("${api.security.secret}")
    private String apiSecret;
    @Value("${api.security.issuer}")
    private String issuer;

    public String getToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return com.auth0.jwt.JWT.create()
                    .withIssuer(issuer)
                    .withSubject(user.getUsername())
                    .withClaim("id", user.getId())
                    .withClaim("email", user.getEmail())
                    .withClaim("roles", user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
                    .withExpiresAt(getExpireDate())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error creating JWT token", exception);
        }
    }

    public String getSubject(String token) {
        if (token == null) {
            throw new IllegalArgumentException("Token cannot be null");
        }
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            DecodedJWT decodedJWT = com.auth0.jwt.JWT.require(algorithm)
                    .withIssuer(issuer)
                    .build()
                    .verify(token);
            String subject = decodedJWT.getSubject();
            if (subject == null) {
                throw new RuntimeException("Invalid token: subject not found");
            }
            return subject;
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Error verifying JWT token", exception);
        }
    }

    private Instant getExpireDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZONE_OFFSET);
    }
}
