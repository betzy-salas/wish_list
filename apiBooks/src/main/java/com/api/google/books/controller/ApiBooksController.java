package com.api.google.books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.google.books.domain.BookRequest;
import com.api.google.books.interfaces.IBookService;

@RequestMapping("/books")
@RestController
public class ApiBooksController {
	
	@Autowired
	private IBookService bookService;

	@CrossOrigin
	@GetMapping("/volumen")
	public ResponseEntity<Object> findVolumen(@RequestParam String title, String author, String publisher){
		BookRequest book = bookService.findVolumen(title, author, publisher);
	    return ResponseEntity.status(HttpStatus.OK).body(book);
	           
	}
}
