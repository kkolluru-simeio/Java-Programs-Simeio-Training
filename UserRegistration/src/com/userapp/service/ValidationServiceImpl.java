package com.userapp.service;

import com.userapp.exceptions.NameExistsException;
import com.userapp.exceptions.PatternNotMatching;
import com.userapp.exceptions.TooLongException;
import com.userapp.exceptions.TooShortException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationServiceImpl implements IValidationService {

	@Override
	public boolean validateUsername(String username) throws NameExistsException {
		String[] usernames = {"kiran", "kk", "katya"};
		for (String uname : usernames) {
			if ( uname.equals(username))
				throw new NameExistsException("Username already exists");
				
	}
		return true;
	}

	@Override
	public boolean validatePassword(String password) throws TooShortException, TooLongException, PatternNotMatching {
	
		if(password.length()< 6) 
			throw new TooShortException("password too short");
		if (password.length() > 15) 
		throw new TooLongException("password too long");
		if(!Pattern.matches("[A-Z]+", password))
			throw new PatternNotMatching("atleast one upper case letter is needed");
		else
			return true;
		
	}

}
