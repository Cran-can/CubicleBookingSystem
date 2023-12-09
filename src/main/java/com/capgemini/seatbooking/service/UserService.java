package com.capgemini.seatbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.seatbooking.dto.UserDto;
import com.capgemini.seatbooking.entity.User;
import com.capgemini.seatbooking.exception.RegistrationException;
import com.capgemini.seatbooking.repository.UserRepository;
import com.capgemini.seatbooking.util.UserType;

//UserService.java
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
     user.setPassword(userDto.getPassword());
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
}

