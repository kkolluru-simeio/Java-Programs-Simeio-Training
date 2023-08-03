package com.groupon.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.groupon.model.User;

public class UserMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		 User user = new User();
		 user.setUserId(rs.getString("userId"));
		 user.setFirstName(rs.getString("firstName"));
		user.setMiddleName(rs.getString("middleName"));
		user.setLastName(rs.getString("lastName"));
		user.setEmail(rs.getString("email"));
		user.setDateOfBirth(rs.getDate("dateOfBirth"));
		user.setSecurityQuestion(rs.getString("securityQuestion"));
		user.setSecurityAnswer(rs.getString("securityAnswer"));
		user.setCity("city");
		user.setPassword(rs.getString("password"));
		return user;
		
	}

}
