package com.example.demomarket.web.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component("JWTUtil")
public class JWTUtil {
    private static final String KEY = "KEY776162626662717171!";
    public String generateToken(UserDetails userDetails){
        return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*10))
                .signWith(SignatureAlgorithm.HS256, KEY)
                .compact();
    }

    public boolean isValid(String token, UserDetails userDetails){
        return userDetails.getUsername().equals(extractUsername(token)) && !isExpired(token);
    }
    private boolean isExpired(String token){
        return getClaims(token).getExpiration().before(new Date());
    }
    public String extractUsername(String token){
        return getClaims(token).getSubject();
    }
    private Claims getClaims(String token){
        return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
    }
}
