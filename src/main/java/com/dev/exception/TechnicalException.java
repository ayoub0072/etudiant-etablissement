package com.dev.exception;

public class TechnicalException extends Exception{

	private static final long serialVersionUID = 1L;
	private String errorMessage;
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public TechnicalException() {
		super();
	}
	
	public TechnicalException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

}
