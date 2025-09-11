package com.todo.todoapplication.services;

import io.github.cdimascio.dotenv.Dotenv;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

    private final SecretKey secretKey;
    private final long expiration = 1000 * 60 * 60 * 24;

    public JwtService() {

        Dotenv dotenv = Dotenv.load();
        String secret = dotenv.get("JWT_SECRET");


        if (secret == null || secret.length() < 32) {
            throw new IllegalStateException("JWT_SECRET must be set in .env and at least 32 characters long");
        }


        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String generateToken(String userId) {
        return Jwts.builder()
                .setSubject(userId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUserId(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public String AuthToken(String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new RuntimeException("Authorization token is missing or invalid");
        }
        String token = authHeader.substring(7);
        String userId;
        try {
            userId = extractUserId(token);
        } catch (Exception e) {
            throw new RuntimeException("Invalid or expired token");
        }
        return userId;
    }

}
