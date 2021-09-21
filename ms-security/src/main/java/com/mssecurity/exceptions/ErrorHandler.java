package com.mssecurity.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import io.jsonwebtoken.SignatureException;

@ControllerAdvice
public class ErrorHandler {
	
	
	/*@ExceptionHandler({MethodArgumentNotValidException.class})
	public ResponseEntity<ErrorInfo> methodArgumentNotValidException( MethodArgumentNotValidException exception){
		ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), "Bad Request The request is invalid.");
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);	
	}
	
	@ExceptionHandler({HttpMessageConversionException.class})
	public ResponseEntity<ErrorInfo> httpMessageConversionException( HttpMessageConversionException exception){
		ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), "Bad Request The request is invalid.");
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);	
	}*/
	
	@ExceptionHandler({SignatureException.class})
	public ResponseEntity<ErrorInfo> signatureException( SignatureException signatureException){
		ErrorInfo errorInfo = new ErrorInfo(HttpStatus.FORBIDDEN.value(), "Forbiden.");
		return new ResponseEntity<>(errorInfo, HttpStatus.FORBIDDEN);	
	}
	
	@ExceptionHandler({UserNotFound.class})
	public ResponseEntity<ErrorInfo> NotFoundUser( UserNotFound userNotFound){
		ErrorInfo errorInfo = new ErrorInfo(HttpStatus.NOT_FOUND.value(), "User not found.");
		return new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);	
	}
	
	@ExceptionHandler({HttpRequestMethodNotSupportedException.class})
	public ResponseEntity<ErrorInfo> httpRequestMethodNotSupportedException( HttpRequestMethodNotSupportedException httpRequestMethodNotSupportedException){
		ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), "Bad Request The method request is invalid.");
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);	
	}
	
	
}
