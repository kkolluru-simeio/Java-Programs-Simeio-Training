package com.groupon.repository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.groupon.model.Deal;
import com.groupon.model.User;
import com.groupon.model.UserDTO;
import com.groupon.model.UserLoginDTO;
import com.groupon.utils.UserQueries;

@Component
public class UserRepositoryImpl implements IUserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Override
	public void addUser(User user) {
		String sql = UserQueries.INSERTQUERY;
		Object[] userArray = {user.getUserId(), user.getFirstName(), user.getMiddleName(), user.getLastName(),  user.getEmail(), user.getDateOfBirth(),user.getSecurityQuestion(), user.getSecurityAnswer(), user.getCity(), user.getPassword()};
		jdbcTemplate.update(sql, userArray);
		
	}

	@Override
	public int updateUser(User user) {
		Object[] userArray = {user.getFirstName(), user.getMiddleName(), user.getLastName(),  user.getEmail(), user.getDateOfBirth(),user.getSecurityQuestion(), user.getSecurityAnswer(), user.getCity(), user.getPassword(), user.getUserId()};
		return jdbcTemplate.update(UserQueries.UPDATEQUERY, userArray);
	}
	
	@Override
	public int updatePassword(UserDTO userDTO) {
		return jdbcTemplate.update(UserQueries.UPDATEPASSWORDQUERY, userDTO.getPassword(), userDTO.getUserId());

	}

	@Override
	public void deleteUser(String userId) {
		jdbcTemplate.update(UserQueries.DELETEQUERY, userId);
	}
	
	@Override
	public String findPasswordforUser(String email) {
		System.out.println(email);
		return (String) jdbcTemplate.queryForObject(UserQueries.GETPASSWORDQUERY, new Object[] { email } , String.class);
	}

	@Override
	public List<User> findAllUsers() {
		return jdbcTemplate.query(UserQueries.QUERYALL, new UserMapper());
	}
	
	@Override
	public User findUserById(String userId) {
		
		return jdbcTemplate.queryForObject(UserQueries.QUERYBYID, new UserMapper(), userId);
	}

	@Override
	public List<User> findUsersByDoBRange(Date startDate, Date endDate) {
		System.out.println(startDate);
		System.out.println(endDate);
		return jdbcTemplate.query(UserQueries.QUERYBYDOBRANGE, new UserMapper(), startDate, endDate);
				}

	@Override
	public String findUserIdFromEmail(String email) {
		return (String) jdbcTemplate.queryForObject(UserQueries.GETUSERIDFROMEMAIL, new Object[] { email } , String.class);
		
	}



	

}
