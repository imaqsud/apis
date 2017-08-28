package com.maiq.jerseyjava.exceptions;

public class DataNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8428750545363866332L;
	
	public DataNotFoundException(String message) {
		
		super(message);
	}

}
