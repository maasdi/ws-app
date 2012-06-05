package com.maasdianto.ws.domain;

public class FarmCertificationException extends RuntimeException {

	private static final long serialVersionUID = 5807918668926386730L;

	public FarmCertificationException(String message) {
		super(message);
	} 

	public FarmCertificationException(Throwable cause) {
		super(cause);
	}

	public FarmCertificationException(String message, Throwable cause) {
		super(message, cause);
	}

	public FarmCertificationException() {
	}

}
