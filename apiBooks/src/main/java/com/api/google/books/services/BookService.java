package com.api.google.books.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.google.books.domain.Book;
import com.api.google.books.domain.BookRequest;
import com.api.google.books.interfaces.IBookService;

@Service
public class BookService implements IBookService {
	
	@Value("${api.key}")
	private String apiKey;
	
	@Value("${api.url}")
	private String apiURL;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public BookRequest findVolumen(String title, String author, String publisher) {
		
		//List<Object> book = Arrays.asList(null);
		
		BookRequest bookSummary = restTemplate.getForObject(generateURL(title, author, publisher), BookRequest.class);
		return bookSummary;

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
