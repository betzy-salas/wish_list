package com.api.google.books.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.google.books.client.ISecurityClient;
import com.api.google.books.domain.BookRequest;
import com.api.google.books.exception.InvalidCredentials;
import com.api.google.books.interfaces.IBookService;

@RequestMapping("/books")
@RestController
public class ApiBooksController {
	
	@Autowired
	private IBookService bookService;	
	@Autowired
	ISecurityClient securityClient;

	//@CrossOrigin
	@GetMapping("/volumen")
	public ResponseEntity<Object> findVolumen(@RequestParam String title, String author, 
			String publisher, HttpServletRequest req) throws InvalidCredentials{
		String token = req.getHeader("Authorization");
		String username = req.getHeader("Username");
		String password = req.getHeader("Password");
		
		Optional<BookRequest> book = bookService.findVolumen(title, author, publisher, token, username, password);
	    
		if(book != null)
			return ResponseEntity.status(HttpStatus.OK).body(book);
		else
			throw new InvalidCredentials("");
	           
	}
}
