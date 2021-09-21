package com.api.google.books.interfaces;

import java.util.List;
import java.util.Optional;

import com.api.google.books.domain.Book;
import com.api.google.books.domain.BookRequest;

public interface IBookService {
	BookRequest findVolumen(String title, String author, String publisher);
}
