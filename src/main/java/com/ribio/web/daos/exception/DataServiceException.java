package com.ribio.web.daos.exception;

public class DataServiceException extends Exception{

	private static final long serialVersionUID = 1L;

	public DataServiceException(String msg, Throwable exception) {
		super(msg, exception);
	}

	public DataServiceException(String message) {
		super(message);
	}

}