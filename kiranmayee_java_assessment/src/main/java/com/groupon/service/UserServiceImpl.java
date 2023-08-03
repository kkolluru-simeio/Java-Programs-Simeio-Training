package com.groupon.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.groupon.exceptions.DealNotFoundException;
import com.groupon.exceptions.IncorrectUserDetailsException;
import com.groupon.exceptions.UserNotFoundException;
import com.groupon.model.AccessLog;
import com.groupon.model.ActivityType;
import com.groupon.model.CityCodes;
import com.groupon.model.Deal;
import com.groupon.model.User;
import com.groupon.model.UserConverter;
import com.groupon.model.UserDTO;
import com.groupon.model.UserDTOSkipPassword;
import com.groupon.model.UserLoginDTO;
import com.groupon.repository.ILogRepository;
import com.groupon.repository.IUserRepository;

@Component
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepository userRepository;
	
	@Autowired
	ILogRepository logRepository;

	@Autowired
	UserConverter userConverter;

	@Override
	public UserDTO addUser(User user) throws IncorrectUserDetailsException {
		validateUser(user);
		String userId = generateUserId(user);
		System.out.println("user id " + userId);
		user.setUserId(userId);
		String password = generatePassword();
		System.out.println("generated password: " + password);
		String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
		System.out.println(hashedPassword);
		user.setPassword(hashedPassword);
		System.out.println(user);
		userRepository.addUser(user);
		AccessLog accessLog = new AccessLog();
		accessLog.setUserId(user.getUserId());
		accessLog.setActivityType(ActivityType.REGISTER);
		accessLog.setLogTimestamp(LocalDateTime.now());
		accessLog.setSuccessStatus(true);
		accessLog.setNoOfAttempts(1);
		logRepository.addEntry(accessLog);
		return userConverter.toDTOResponse(user);

	}

	// validate User email, city and date of birth

	void validateUser(User user) throws IncorrectUserDetailsException {

		if (!user.getEmail().matches("^(.+)@(.+)$"))
			throw new IncorrectUserDetailsException("Email not properly formatted");
		int MAX_VALID_YR = LocalDate.now().getYear() - 18;
		int MIN_VALID_YR = LocalDate.now().getYear() - 150;
		int dobYear = user.getDateOfBirth().toLocalDate().getYear();
		int dobMonth = user.getDateOfBirth().getMonth();
		int dobDate = user.getDateOfBirth().getDate();

		if (dobYear < MIN_VALID_YR || dobYear > MAX_VALID_YR)
			throw new IncorrectUserDetailsException("Not a valid date given for date of birth");
		if (dobMonth <= 0 || dobMonth > 12)
			throw new IncorrectUserDetailsException("Not a valid date given for date of birth");
		int[] months = { 1, 3, 5, 7, 8, 10, 12 };
		Arrays.asList(months).contains(dobMonth);
		if (dobDate < 0 || dobDate > 31)
			throw new IncorrectUserDetailsException("Not a valid date given for date of birth");
		int[] shortMonths = { 2, 4, 6, 9, 11 };
		Arrays.asList(shortMonths).contains(dobMonth);
		if (dobDate < 0 || dobDate > 30)
			throw new IncorrectUserDetailsException("Not a valid date given for date of birth");
		if (dobMonth == 2 && isLeap(dobYear) && dobDate > 29)
			throw new IncorrectUserDetailsException("Not a valid date given for date of birth");
		if (dobMonth == 2 && !isLeap(dobYear) && dobDate > 28)
			throw new IncorrectUserDetailsException("Not a valid date given for date of birth");

	}

	boolean isLeap(int year) {
		// Return true if year is
		// a multiple of 4 and not
		// multiple of 100.
		// OR year is multiple of 400.
		return (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));
	}

	String generateUserId(User user) {
		String userId;
		System.out.println("generating unique user id");
		for (int i = 0; i <= 9; i++) {
			if (user.getMiddleName().trim() != "") {

				userId = (CityCodes.valueOf(user.getCity().toUpperCase()).cityCode + user.getFirstName().substring(0, 1)
						+ user.getMiddleName().substring(0, 1) + user.getLastName().substring(0, 1)).toUpperCase() + i;
			} else
				userId = (CityCodes.valueOf(user.getCity().toUpperCase()).cityCode + user.getFirstName().substring(0, 2)
						+ user.getLastName().substring(0, 1)).toUpperCase() + i;
			try {
			User userById = userRepository.findUserById(userId);
			}
			catch(DataAccessException ex) {
				return userId;
			}
		}
		throw new UserNotFoundException("failed to generate unique user Id");

	}

	// Rules to generate password
	// Atleast one capital letter
	// Atleast one lower case letter
	// Atleast one numerical
	// Minimum 8 characters
	// Atleast one special character
	// Allowed Ascii special chars
	// # Number sign 35
	// $ Dollar sign 36
	// % Percent sign 37
	// & ampersand 38

	String generatePassword() {

		String upperCaseLetter = RandomStringUtils.random(1, 65, 90, true, true);
		String lowerCaseLetter = RandomStringUtils.random(1, 97, 122, true, true);
		String number = RandomStringUtils.randomNumeric(1);
		String specialCharacter = RandomStringUtils.random(1, 35, 38, false, false);
		String remainingCharacters = RandomStringUtils.randomAlphanumeric(4);
		String combinedCharacters = upperCaseLetter.concat(lowerCaseLetter).concat(number).concat(specialCharacter)
				.concat(remainingCharacters);
		List<Character> pwdChars = combinedCharacters.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
		Collections.shuffle(pwdChars);
		String password = pwdChars.stream().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
				.toString();
		
		return password;
	}

	@Override
	public int updateUser(User user) {
		return userRepository.updateUser(user);
	}
	
	@Override
	public int updatePassword(UserDTO userDTO) {
		
		userDTO.setPassword(BCrypt.hashpw(userDTO.getPassword(), BCrypt.gensalt()));
		return userRepository.updatePassword(userDTO);
	}

	@Override
	public void deleteUser(String userId) {
		userRepository.deleteUser(userId);

	}
	
	@Override
	public boolean userLogin(UserLoginDTO userLoginDTO) {
		System.out.println("at user service" + userLoginDTO.getPassword());
		 String storedPassword = userRepository.findPasswordforUser(userLoginDTO.getEmail());
		 return BCrypt.checkpw(userLoginDTO.getPassword(), storedPassword);
	}
	
	@Override
	public String getUserIdFromEmail(String email) {
		try {
		return userRepository.findUserIdFromEmail(email);
		}
		catch(DataAccessException ex) {
			throw new UserNotFoundException("Invalid email");
		}
		
	}
	
	

	@Override
	public List<UserDTOSkipPassword> getAllUsers() {

		List<User> userList = userRepository.findAllUsers();
		if (userList.isEmpty())
			throw new UserNotFoundException("No user found in repo");
		List<UserDTOSkipPassword> userDTOList = userList.stream().map(userObj -> userConverter.toDTOskipPassword(userObj))
				.collect(Collectors.toList());
		return userDTOList;
	}

	@Override
	public UserDTOSkipPassword getUserById(String userId) {
		try {
			User user = userRepository.findUserById(userId);
			return userConverter.toDTOskipPassword(user);
			}
			catch(DataAccessException ex) {
				throw new UserNotFoundException("Invalid Id");
			}
		
	}

	@Override
	public List<UserDTOSkipPassword> getUsersByAge(int ageFrom, int ageTo) {
		Date endDate = Date.valueOf(LocalDate.now());
		endDate.setYear(endDate.getYear() - ageFrom);
		Date startDate = Date.valueOf(LocalDate.now());
		startDate.setYear(startDate.getYear() - ageTo);
		List<User> userList = userRepository.findUsersByDoBRange(startDate, endDate);
		if (userList.isEmpty())
			throw new UserNotFoundException("No user found in repo between specified age range");
		List<UserDTOSkipPassword> userDTOList = userList.stream().map(userObj -> userConverter.toDTOskipPassword(userObj))
				.collect(Collectors.toList());
		return userDTOList;
	}

	



}
