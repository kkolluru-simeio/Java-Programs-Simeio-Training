	package com.userapp.service;

import com.userapp.exceptions.NameExistsException;
import com.userapp.exceptions.PatternNotMatching;
import com.userapp.exceptions.TooLongException;
import com.userapp.exceptions.TooShortException;

public interface IValidationService {
	
	  boolean validateUsername(String username) throws NameExistsException;
	  boolean validatePassword(String password) throws TooShortException,TooLongException,PatternNotMatching;

}
