package com.ribio.web.services.exception;

public class BusinessServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public BusinessServiceException(String message, Throwable e) {
		super(message, e);
	}

	public BusinessServiceException(String message) {
		super(message);
	}

}