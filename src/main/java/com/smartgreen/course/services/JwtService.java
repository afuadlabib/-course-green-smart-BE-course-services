package com.smartgreen.course.services;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;

@Service
@Transactional
public class JwtService {
    private Jwts jwts;
    private final byte[] secret = Base64.getDecoder().decode("ABdwq5iK0Zixx5uj94fU+TQhjjJymulIGCCcfvniQh4=");


    public String generateToken(String id) {
        Instant now = Instant.now();
        return Jwts.builder()
                .subject(id)
                .issuedAt(Date.from(now))
                .expiration(Date.from(now.plus(20, ChronoUnit.MINUTES )))
                .signWith(Keys.hmacShaKeyFor(secret))
                .compact();
    }
    public String getPayloadBearerToken(String token){
        String[] jwts = token.split(" ");
        Jws<Claims> jws = Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(secret))
                .build()
                .parseSignedClaims(jwts[1]);

        return jws.getPayload().getSubject();
    }

}