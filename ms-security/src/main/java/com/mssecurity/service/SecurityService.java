package com.mssecurity.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mssecurity.client.IUserClient;
import com.mssecurity.domain.Token;
import com.mssecurity.domain.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Base64;

@Service
public class SecurityService {
    private static final int EXPIRATION_TIME = 1000 * 60 * 60;
    private final String SECRET_KEY;
    
    @Autowired
    Token token;
    
    @Autowired
	IUserClient userClient;
 
    public SecurityService() {
        SECRET_KEY = Base64.getEncoder().encodeToString("ESTA ES LA CADENA".getBytes());
    }
 
    public Token createToken(User user) {
    	
    	boolean isFound = true;
    	
		try {
			ResponseEntity<Optional<com.mssecurity.model.User>> clientUser = userClient.checkUser(user.getUsername());
			if (!clientUser.getBody().get().getPassword().equals(user.getPassword()))
				isFound = false;	

		} catch (Exception e) {
			isFound = false;
		}
		
		if (isFound) {
			token.setUser(new User(user.getUsername(), user.getPassword()));
	        token.setToken(Jwts.builder()
	                .setSubject(user.getUsername())
	                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
	                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
	                .compact());
	        return token;
        }
        
		return null;
    }
 
    public Boolean hasTokenExpired(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration()
                .before(new Date());
    }
 
    public Boolean validateToken(String token, User user) {
        String username = extractUsername(token);
        return (user.getUsername().equals(username) && !hasTokenExpired(token));
 
    }
 
    public String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}