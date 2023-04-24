package com.exam.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.exam.helper.UserNotFoundException;

@RestControllerAdvice
public class UserExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> userNotFoundException(UserNotFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<String> userNameNotFoundHandler(UsernameNotFoundException e){
		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
}
