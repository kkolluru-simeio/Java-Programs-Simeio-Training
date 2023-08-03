package com.groupon.repository;

import java.util.Date;
import java.util.List;

import com.groupon.model.Deal;
import com.groupon.model.User;
import com.groupon.model.UserDTO;
import com.groupon.model.UserLoginDTO;

public interface IUserRepository {

	void addUser(User user);
	
	int updateUser(User user);
	
	int updatePassword(UserDTO userDTO);
	
	void deleteUser(String userId);
	
	List<User> findAllUsers();
	
	User findUserById(String userId);
	
	List<User> findUsersByDoBRange(Date startDate, Date endDate);

	String findPasswordforUser(String email);

	String findUserIdFromEmail(String email);
	
	

}
