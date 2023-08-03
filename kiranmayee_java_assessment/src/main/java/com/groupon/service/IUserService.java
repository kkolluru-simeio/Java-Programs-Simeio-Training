package com.groupon.service;

import java.util.List;

import com.groupon.exceptions.IncorrectUserDetailsException;
import com.groupon.model.User;
import com.groupon.model.UserDTO;
import com.groupon.model.UserDTOSkipPassword;
import com.groupon.model.UserLoginDTO;

public interface IUserService {
	
	UserDTO addUser(User user) throws IncorrectUserDetailsException;

	int updateUser(User user);
	
	int updatePassword(UserDTO userDTO);

	void deleteUser(String userId);
	
	boolean userLogin(UserLoginDTO userLoginDTO);
	
	List<UserDTOSkipPassword> getAllUsers();
	
	UserDTOSkipPassword getUserById(String UserId);
	
	List<UserDTOSkipPassword> getUsersByAge(int ageFrom, int ageTo);
	
	String getUserIdFromEmail(String email);

}
