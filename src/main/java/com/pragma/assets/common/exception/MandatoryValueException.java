package com.pragma.assets.common.exception;

public class MandatoryValueException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
    public MandatoryValueException(String message) {
        super(message);
    }
}
