// JwtTokenProvider.java
package com.example.demo.security;


import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;


import java.util.Date;


@Component
public class JwtTokenProvider {


private final String secret = "mySecretKey"; // ideally from properties
private final long validityInMs = 3600000; // 1 hour


public String generateToken(Authentication auth, Long userId, String email, String role) {
return Jwts.builder()
.setSubject(email)
.claim("userId", userId)
.claim("email", email)
.claim("role", role)
.setIssuedAt(new Date())
.setExpiration(new Date(System.currentTimeMillis() + validityInMs))
.signWith(SignatureAlgorithm.HS512, secret)
.compact();
}


public boolean validateToken(String token) {
try {
Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
return true;
} catch (JwtException | IllegalArgumentException e) {
return false;
}
}


public String getEmailFromToken(String token) {
return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
}


public String getRoleFromToken(String token) {
return (String) Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().get("role");
}


public Long getUserIdFromToken(String token) {
Object id = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().get("userId");
return id instanceof Integer ? ((Integer) id).longValue() : (Long) id;
}
}