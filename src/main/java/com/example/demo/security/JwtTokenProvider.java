package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private final Key key;
    private final long expirationMillis;

    public JwtTokenProvider(String secret, long expirationMillis) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.expirationMillis = expirationMillis;
    }

    public String generateToken(Authentication authentication,
                                Long userId,
                                String email,
                                String role) {

        return Jwts.builder()
                .claim("userId", userId)
                .claim("email", email)
                .claim("role", role)
                .setExpiration(
                        new Date(System.currentTimeMillis() + expirationMillis)
                )
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Long getUserIdFromToken(String token) {
        Claims claims = getClaims(token);

        // Fallback to subject if userId claim missing
        if (claims.get("userId") == null) {
            return Long.valueOf(claims.getSubject());
        }

        return Long.valueOf(claims.get("userId").toString());
    }

    public String getEmailFromToken(String token) {
        return getClaims(token).get("email").toString();
    }

    public String getRoleFromToken(String token) {
        return getClaims(token).get("role").toString();
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
