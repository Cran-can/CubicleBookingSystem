package com.capgemini.seatbooking.exception;

public class RegistrationException extends RuntimeException {
	private static final long serialVersionUID = 1L;

     public RegistrationException(String message) {
        super(message);
    }
}

