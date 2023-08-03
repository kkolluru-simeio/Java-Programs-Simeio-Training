package com.groupon.model;

import org.springframework.stereotype.Component;



@Component
public class UserConverter {

		
	public UserDTO toDTOResponse(User user) {
		
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUserId(user.getUserId());
		userDTO.setPassword(user.getPassword());
		return userDTO;
	}
	
	public UserDTOSkipPassword toDTOskipPassword(User user) {
		
		UserDTOSkipPassword userDTOSkipPassword = new UserDTOSkipPassword();
		
		userDTOSkipPassword.setUserId(user.getUserId());
		userDTOSkipPassword.setFirstName(user.getFirstName());
		userDTOSkipPassword.setMiddleName(user.getMiddleName());
		userDTOSkipPassword.setLastName(user.getLastName());
		userDTOSkipPassword.setEmail(user.getEmail());
		userDTOSkipPassword.setDateOfBirth(user.getDateOfBirth());
		userDTOSkipPassword.setSecurityQuestion(user.getSecurityQuestion());
		userDTOSkipPassword.setSecurityAnswer(user.getSecurityAnswer());
		userDTOSkipPassword.setCity(user.getCity());
		return userDTOSkipPassword;
	}
}