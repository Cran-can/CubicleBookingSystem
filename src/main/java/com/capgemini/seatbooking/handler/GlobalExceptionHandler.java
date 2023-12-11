// GlobalExceptionHandler.java
package com.capgemini.seatbooking.handler;

import com.capgemini.seatbooking.exception.LoginException;
import com.capgemini.seatbooking.exception.RegistrationException;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RegistrationException.class)
    public ResponseEntity<Object> handleRegistrationException(RegistrationException ex) {
    	ApiError error = new ApiError();
    	error.setStatus(HttpStatus.BAD_REQUEST);
    	error.setMessage("Invalid Input");
    	error.setTimestamp(LocalDateTime.now());
    	return new ResponseEntity<>(error, HttpStatus.valueOf(400));
    }
    
    @ExceptionHandler(LoginException.class)
    public ResponseEntity<Object> handleLoginException(LoginException ex){
    	ApiError error = new ApiError();
    	error.setStatus(HttpStatus.UNAUTHORIZED);
    	error.setMessage("Invalid credentials");
    	error.setTimestamp(LocalDateTime.now());
    	return new ResponseEntity<>(error, HttpStatus.valueOf(401));
    }

    // Add more exception handlers for other exceptions if needed
}
