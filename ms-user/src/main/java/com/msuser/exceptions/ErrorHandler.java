package com.msuser.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
	
	@ExceptionHandler({DataIntegrityViolationException.class})
	public ResponseEntity<ErrorInfo> dataIntegrityViolationException( DataIntegrityViolationException exception){
		ErrorInfo errorInfo = new ErrorInfo(HttpStatus.CONFLICT.value(), "Conflict The username is already taken.");
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
	
	@ExceptionHandler({Exception.class})
	public ResponseEntity<ErrorInfo> NotFoundUser( Exception exception){
		ErrorInfo errorInfo = new ErrorInfo(HttpStatus.NOT_FOUND.value(), "User not found.");
		return new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);	
	}
	
	
	//HttpMessageConversionException
	//RuntimeException
	
}
