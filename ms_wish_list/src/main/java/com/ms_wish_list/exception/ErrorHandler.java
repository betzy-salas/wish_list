package com.ms_wish_list.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
	
	@ExceptionHandler({DataIntegrityViolationException.class})
	public ResponseEntity<ErrorInfo> dataIntegrityViolationException( DataIntegrityViolationException exception){
		ErrorInfo errorInfo = new ErrorInfo(HttpStatus.CONFLICT.value(), "Conflict The Wish List not exists.");
		return new ResponseEntity<>(errorInfo, HttpStatus.CONFLICT);	
	}
	
	@ExceptionHandler({MethodArgumentNotValidException.class})
	public ResponseEntity<ErrorInfo> methodArgumentNotValidException( MethodArgumentNotValidException exception){
		ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), "Bad Request The request is invalid.");
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);	
	}
	
	@ExceptionHandler({HttpMessageConversionException.class})
	public ResponseEntity<ErrorInfo> httpMessageConversionException( HttpMessageConversionException exception){
		ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), "Bad Request The request is invalid.");
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);	
	}
	
	@ExceptionHandler({UserNotFound.class})
	public ResponseEntity<ErrorInfo> NotFoundUser( UserNotFound userNotFound){
		ErrorInfo errorInfo = new ErrorInfo(HttpStatus.NOT_FOUND.value(), "User not found.");
		return new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);	
	}
	
	@ExceptionHandler({WishNotFound.class})
	public ResponseEntity<ErrorInfo> NotFoundWishList( WishNotFound wishNotFound){
		ErrorInfo errorInfo = new ErrorInfo(HttpStatus.NOT_FOUND.value(), "Wish List not found.");
		return new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);	
	}
	
	@ExceptionHandler({WishListItemNotFound.class})
	public ResponseEntity<ErrorInfo> NotFoundWishList( WishListItemNotFound wishListItemNotFound){
		ErrorInfo errorInfo = new ErrorInfo(HttpStatus.NOT_FOUND.value(), "Wish List Item not found.");
		return new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);	
	}
	
	@ExceptionHandler({HttpRequestMethodNotSupportedException.class})
	public ResponseEntity<ErrorInfo> httpRequestMethodNotSupportedException( HttpRequestMethodNotSupportedException httpRequestMethodNotSupportedException){
		ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), "Bad Request The method request is invalid.");
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);	
	}
	
	
}
