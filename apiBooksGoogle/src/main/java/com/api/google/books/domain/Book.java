package com.api.google.books.domain;

import java.util.List;

public class Book {

	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	private String  idBook;
	private String titleBook;
	private List<String> authorsBook;
	private String publisherBook;
	
	public String getIdBook() {
		return idBook;
	}
	public void setIdBook(String idBook) {
		this.idBook = idBook;
	}
	public String getTitleBook() {
		return titleBook;
	}
	public void setTitleBook(String titleBook) {
		this.titleBook = titleBook;
	}
	public List<String> getAuthorsBook() {
		return authorsBook;
	}
	public void setAuthorsBook(List<String> authorsBook) {
		this.authorsBook = authorsBook;
	}
	public String getPublisherBook() {
		return publisherBook;
	}
	public void setPublisherBook(String publisherBook) {
		this.publisherBook = publisherBook;
	}

}
