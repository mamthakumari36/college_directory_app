package org.jsp.cda.responseStructure;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResponseStructure <T>
{
	private int status;
	private String message;
	private T body;

}
