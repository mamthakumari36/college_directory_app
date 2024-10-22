package org.jsp.cda.exceptionhandler;

import org.jsp.cda.exceptionclasses.NoStudentFoundException;
import org.jsp.cda.responseStructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentExceptionHandler 
{
	@ExceptionHandler(NoStudentFoundException.class)
	public ResponseEntity<?> noStudentFoundExceptionHandler(NoStudentFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder()
				.status(HttpStatus.NOT_FOUND.value()).message("Invalid Student Id").body(e.getMessage()).build());
	}

}
