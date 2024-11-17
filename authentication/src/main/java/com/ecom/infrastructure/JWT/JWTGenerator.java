package com.ecom.infrastructure.JWT;

import com.ecom.domain.entity.Role;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JWTGenerator {
    private String secret = "yourBase64EncodedSecretKey";
    Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateToken(String username, List<Role> roles) {
        // Extract role names or IDs
        List<String> roleNames = roles.stream()
                .map(Role::getName)  // Assuming Role has a 'name' field
                .collect(Collectors.toList());

        return Jwts.builder()
                .setSubject(username)
                .claim("roles", roleNames)  // Pass only the role names as a list
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
}


