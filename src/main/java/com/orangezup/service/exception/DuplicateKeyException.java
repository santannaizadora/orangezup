package com.orangezup.service.exception;

import org.springframework.dao.DataIntegrityViolationException;

public class DuplicateKeyException extends DataIntegrityViolationException{
	private static final long serialVersionUID = 1L;
	
	public DuplicateKeyException(String message) {
		super (message);
	}
	
	public DuplicateKeyException(String message, Throwable cause) {
		super(message, cause);
	}
}
