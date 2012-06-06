package com.maasdianto.ws.domain;

public class FileException extends RuntimeException {
	
	private static final long serialVersionUID = 4850170581369611397L;

	public FileException(String message) {
		super(message);
	}
	
	public FileException() {
	}

}
