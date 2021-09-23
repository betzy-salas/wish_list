package com.mssecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mssecurity.domain.Token;
import com.mssecurity.domain.User;
import com.mssecurity.exceptions.UserNotFound;
import com.mssecurity.exceptions.ExpiredJwtException;
import com.mssecurity.service.SecurityService;

@RestController
@RequestMapping("/authentication")
public class SecurityController {
 
    @Autowired
	private SecurityService securityService;
 
    @PostMapping("/login")
    public ResponseEntity<Token>createToken(@RequestBody User user) throws UserNotFound {
    	
		Token token = securityService.createToken(user);
		if (token !=  null)
			return ResponseEntity.status(HttpStatus.CREATED).body(token);
		else
			throw new UserNotFound("");
    }
    
    @PostMapping("/validate")
    public ResponseEntity<Boolean> validateToken(@RequestBody Token token) throws ExpiredJwtException{
    	
    	Boolean validateJwt = securityService.validateToken(token.getToken(), token.getUser());
    	
    	if (validateJwt)
    		return ResponseEntity.status(HttpStatus.OK).body(securityService.validateToken(token.getToken(), token.getUser()));
    	else
    		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(false);
    }
}