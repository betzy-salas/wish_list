package com.api.google.books.interfaces;

import java.util.Optional;

import com.api.google.books.domain.BookRequest;

public interface IBookService {
	Optional<BookRequest> findVolumen(String title, String author, String publisher, String token, String username, String password);
}
