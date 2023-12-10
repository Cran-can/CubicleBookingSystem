// GlobalExceptionHandler.java
package com.capgemini.seatbooking.handler;

import com.capgemini.seatbooking.exception.LoginException;
import com.capgemini.seatbooking.exception.RegistrationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RegistrationException.class)
    public ResponseEntity<String> handleRegistrationException(RegistrationException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(LoginException.class)
    public ResponseEntity<String> handleLoginException(LoginException ex){
    	return new ResponseEntity<>(ex.getMessage(),HttpStatus.UNAUTHORIZED);
    }

    // Add more exception handlers for other exceptions if needed
}
