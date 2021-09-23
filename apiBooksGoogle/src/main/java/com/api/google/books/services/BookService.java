package com.api.google.books.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.google.books.client.ISecurityClient;
import com.api.google.books.domain.BookRequest;
import com.api.google.books.interfaces.IBookService;
import com.api.google.books.models.Token;
import com.api.google.books.models.User;

@Service
public class BookService implements IBookService {
	
	@Value("${api.key}")
	private String apiKey;
	
	@Value("${api.url}")
	private String apiURL;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	ISecurityClient securityClient;
	
	@Override
	public Optional<BookRequest> findVolumen(String title, String author, String publisher, String token, String username, String password) {
		Boolean isValidAuthentication = true;
		Token tokenUser = new Token (token, new User(username, password));
		
		try {
			ResponseEntity<Boolean> user = securityClient.validateToken(tokenUser);
		} catch (Exception e) {
			isValidAuthentication = false;
		}
		
		if (isValidAuthentication)
			return Optional.ofNullable( restTemplate.getForObject(generateURL(title, author, publisher), BookRequest.class));
		else
			return null;

	}
	
	public String generateURL(String title, String author, String publisher) {
		String completedUrl = "";
		
		completedUrl= (!title.isEmpty()) 
				? completedUrl.concat("?q=intitle:").concat(title) 
				: completedUrl.concat("");
		completedUrl = (!author.isEmpty()) 
				? (completedUrl.isEmpty() 
						? completedUrl.concat("?q=inauthor:").concat(author) 
						: completedUrl.concat("+inauthor:").concat(author)) 
				: completedUrl.concat("") ;
		completedUrl = (!publisher.isEmpty()) 
				? (completedUrl.isEmpty() 
						? completedUrl.concat("?q=inpublisher:").concat(publisher) 
						: completedUrl.concat("+inpublisher:").concat(publisher)) 
				: completedUrl.concat("") ;
		
		return apiURL.concat(completedUrl).concat("&projection=lite").concat("&key=").concat(apiKey);
	}
	
}
