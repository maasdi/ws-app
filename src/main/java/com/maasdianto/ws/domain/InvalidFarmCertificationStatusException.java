package com.maasdianto.ws.domain;

public class InvalidFarmCertificationStatusException extends RuntimeException {

	private static final long serialVersionUID = 5125547814690844785L;

	public InvalidFarmCertificationStatusException(String message) {
		super(message);
	}

	public InvalidFarmCertificationStatusException(Throwable cause) {
		super(cause);
	}

	public InvalidFarmCertificationStatusException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidFarmCertificationStatusException() {
	}

}
