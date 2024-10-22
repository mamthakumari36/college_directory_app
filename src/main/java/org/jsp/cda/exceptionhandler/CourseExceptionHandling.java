package org.jsp.cda.exceptionhandler;

import org.jsp.cda.exceptionclasses.InvalidIdException;
import org.jsp.cda.exceptionclasses.NoCoursesFoundException;
import org.jsp.cda.responseStructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CourseExceptionHandling 
{
	@ExceptionHandler(NoCoursesFoundException.class)
	public ResponseEntity<?> noCoursesFoundExceptionHandler(NoCoursesFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder()
				.status(HttpStatus.NOT_FOUND.value()).message("No Course Found In the DB").body(e.getMessage()).build());
	}
	
	@ExceptionHandler(InvalidIdException.class)
	public ResponseEntity<?> invalidIdExceptionHandler(InvalidIdException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseStructure.builder()
				.status(HttpStatus.BAD_REQUEST.value()).message("Given Id is Invalid").body(e.getMessage()).build());
	}

}
