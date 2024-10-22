package org.jsp.cda.exceptionhandler;

import org.jsp.cda.exceptionclasses.NoDepartmentFoundException;
import org.jsp.cda.exceptionclasses.NoFacultyFoundException;
import org.jsp.cda.responseStructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class FacultyExceptionHandler 
{
	@ExceptionHandler(NoFacultyFoundException.class)
	public ResponseEntity<?> noFacultyFoundExceptionHandler(NoFacultyFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder()
				.status(HttpStatus.NOT_FOUND.value()).message("Invalid Faculty Id").body(e.getMessage()).build());
	}

}
