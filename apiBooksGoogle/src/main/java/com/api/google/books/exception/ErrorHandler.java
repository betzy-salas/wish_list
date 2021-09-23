package com.api.google.books.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
	
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
	
	@ExceptionHandler({InvalidCredentials.class})
	public ResponseEntity<ErrorInfo> NotFoundUser( InvalidCredentials invalidCredentials){
		ErrorInfo errorInfo = new ErrorInfo(HttpStatus.FORBIDDEN.value(), "Invalid Credentials.");
		return new ResponseEntity<>(errorInfo, HttpStatus.FORBIDDEN);	
	}
	
	@ExceptionHandler({HttpRequestMethodNotSupportedException.class})
	public ResponseEntity<ErrorInfo> httpRequestMethodNotSupportedException( HttpRequestMethodNotSupportedException httpRequestMethodNotSupportedException){
		ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), "Bad Request The method request is invalid.");
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);	
	}
	
	
}
