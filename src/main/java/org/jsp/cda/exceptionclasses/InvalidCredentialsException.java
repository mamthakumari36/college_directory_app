package org.jsp.cda.exceptionclasses;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
public class InvalidCredentialsException extends RuntimeException
{
	private String message;
	public InvalidCredentialsException(String message) 
	{
		this.message=message;
	}
	@Override
	public String getMessage()
	{
		return this.message;
		
	}

}
