// UserService.java
package com.capgemini.seatbooking.service;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.seatbooking.dto.LoginDto;
import com.capgemini.seatbooking.dto.UserDto;
import com.capgemini.seatbooking.entity.User;
import com.capgemini.seatbooking.exception.LoginException;
import com.capgemini.seatbooking.exception.RegistrationException;
import com.capgemini.seatbooking.repository.UserRepository;
import com.capgemini.seatbooking.util.UserType;

@Service
public class UserService {

 @Autowired
 private UserRepository userRepository;

 public User registerUser(UserDto userDto) {
     validateUserDto(userDto);
	 
     // Check if the email is already registered
     if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
         throw new RegistrationException("Email already registered");
     }

     // Create a new user
     User user = new User();
     user.setEmail(userDto.getEmail());
     user.setUsername(userDto.getUsername());
     String originalInput=userDto.getPassword();
     String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
     user.setPassword(encodedString);
     user.setUserType(UserType.USER); // Assuming a default user type

     // Save the user to the database
     return userRepository.save(user);
 }
 
 private void validateUserDto(UserDto userDto) {
     if (userDto.getEmail() == null || userDto.getEmail().isEmpty() ||
         userDto.getPassword() == null || userDto.getPassword().isEmpty()) {
         throw new RegistrationException("Email and password cannot be empty.");
     }
 }
 
 public void loginUser(LoginDto loginDto) {
     validateLoginDto(loginDto);

     // Implement user authentication logic
     String originalInput=loginDto.getPassword();
     String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
     
     @SuppressWarnings("unused")  
	User user = userRepository.findByEmailAndPassword(loginDto.getEmail(), encodedString)
             .orElseThrow(() -> new LoginException("Invalid credentials"));
 }

 
 private void validateLoginDto(LoginDto loginDto) {
     if (loginDto.getEmail() == null || loginDto.getEmail().isEmpty() ||
         loginDto.getPassword() == null || loginDto.getPassword().isEmpty()) {
         throw new LoginException("Email and password cannot be empty.");
     }

     // Add more validation rules as needed
 }

}

