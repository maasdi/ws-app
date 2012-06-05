package com.maasdianto.ws.domain;

public class PersonException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public PersonException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public PersonException(String message) {
		super(message);
	}
	
	public PersonException(Throwable cause) {
		super(cause);
	}
	
	public PersonException() {
	}

}
