package com.financetracker.authflow.exceptions;

public class TokenValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public TokenValidationException(String message) {
		super(message);
	}
	
	

}
