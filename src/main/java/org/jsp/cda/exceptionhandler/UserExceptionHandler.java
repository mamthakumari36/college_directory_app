package org.jsp.cda.exceptionhandler;

import org.jsp.cda.exceptionclasses.InvalidCredentialsException;
import org.jsp.cda.exceptionclasses.NoUserFoundException;
import org.jsp.cda.responseStructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler 
{
	@ExceptionHandler(NoUserFoundException.class)
	public ResponseEntity<?> noUserFoundExceptionHandler(NoUserFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder()
				.status(HttpStatus.NOT_FOUND.value()).message("No User Found In the DB").body(e.getMessage()).build());
	}
	
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<?> invalidCredentialsExceptionHandler(InvalidCredentialsException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseStructure.builder()
				.status(HttpStatus.BAD_REQUEST.value()).message("No User Found In the DB").body(e.getMessage()).build());
	}

}
