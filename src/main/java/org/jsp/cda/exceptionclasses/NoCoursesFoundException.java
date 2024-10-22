package org.jsp.cda.exceptionclasses;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
public class NoCoursesFoundException extends RuntimeException
{
	private String message;
	public NoCoursesFoundException(String message) 
	{
		this.message=message;
	}
	@Override
	public String getMessage()
	{
		return this.message;
		
	}

}
