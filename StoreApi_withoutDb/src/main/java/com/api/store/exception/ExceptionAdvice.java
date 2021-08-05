package com.api.store.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.api.store.dto.ErrorDto;

@RestControllerAdvice
public class ExceptionAdvice {

	
	@ExceptionHandler(UrlAlreadyExistsException.class)
	public ResponseEntity<ErrorDto> handleUrlAlreadyExistsException(UrlAlreadyExistsException UrlAlreadyExistsException)
	{
		ErrorDto errordto = new ErrorDto(HttpStatus.NOT_FOUND.value(),UrlAlreadyExistsException.getMessage());		
		return new ResponseEntity<ErrorDto>(errordto,HttpStatus.NOT_FOUND);
	}
	
	
	
	@ExceptionHandler(UrlCannotbeNullException.class)
	public ResponseEntity<ErrorDto> handleUrlCannotbeNullException(UrlCannotbeNullException UrlCannotbeNullException)
	{
		ErrorDto errordto = new ErrorDto(HttpStatus.NOT_FOUND.value(),UrlCannotbeNullException.getMessage());		
		return new ResponseEntity<ErrorDto>(errordto,HttpStatus.NOT_FOUND);
	}
	
	
	
	
}
