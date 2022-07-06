package com.example.demo.security.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.example.demo.exceptions.UnauthorizedException;
import com.example.demo.security.services.UserDetailsImpl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    final private String jwtSecret;

    final private int jwtExpirationMs;
    
    public JwtUtils(@Value("${bookstore.app.jwtSecret}") final String jwtSecret, @Value("${bookstore.app.jwtExpirationMs}") final int jwtExpirationMs) {
    	this.jwtSecret = jwtSecret;
    	this.jwtExpirationMs = jwtExpirationMs;
    }

    public String generateJwtToken(Authentication authentication) {

        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
        Claims claims = Jwts.claims().setSubject(userPrincipal.getUsername());
        claims.put("username", userPrincipal.getUsername());
        claims.put("password", userPrincipal.getPassword());
        return Jwts.builder()
            .setSubject(userPrincipal.getUsername())
            .setClaims(claims)
            .setIssuedAt(new Date())
            .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
            .signWith(SignatureAlgorithm.HS512, jwtSecret)
            .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }
    public String getUserFromJwtToken(String token) {
    	Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
    	return claims.get("username") + " "+ claims.get("password");
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
        	
            logger.error("Invalid JWT token: {}", e.getMessage());
            
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }
    public void validateJwtToke(String authToken) {
    	try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return;
        } catch (SignatureException e) {
        	throw new UnauthorizedException("Invalid JWT signature: "+ e.getMessage());
        } catch (MalformedJwtException e) {
        	throw new UnauthorizedException("Invalid JWT token: "+ e.getMessage());
            
        } catch (ExpiredJwtException e) {
        	throw new UnauthorizedException("JWT token is expired: "+ e.getMessage());
        } catch (UnsupportedJwtException e) {
        	throw new UnauthorizedException("JWT token is unsupported: "+ e.getMessage());
        } catch (IllegalArgumentException e) {
        	throw new UnauthorizedException("JWT claims string is empty: "+ e.getMessage());
        }
    }
}