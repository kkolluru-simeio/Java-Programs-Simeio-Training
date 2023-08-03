package com.groupon.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.groupon.model.AccessLog;
import com.groupon.model.ActivityType;
import com.groupon.model.User;
import com.groupon.model.UserDTO;
import com.groupon.model.UserDTOSkipPassword;
import com.groupon.model.UserLoginDTO;
import com.groupon.service.ILogService;
import com.groupon.service.IUserService;

@RestController
@RequestMapping("/deal-api")
public class UserController {

	@Autowired
	IUserService userService;
	
	@Autowired
	ILogService logService;

	@PostMapping("/users/register")
	ResponseEntity<UserDTO> userRegistration(@RequestBody User user) {
		System.out.println("at user controller - add user");
		UserDTO userDTO = userService.addUser(user);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "user added to db");
		ResponseEntity<UserDTO> responseEntity = new ResponseEntity<UserDTO>(userDTO, headers, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@PutMapping("/users")
	ResponseEntity<Void>  updateUser(@RequestBody User user) {
		userService.updateUser(user);
		return ResponseEntity.accepted().build();
		
	}

	@DeleteMapping("/users/{userId}")
	ResponseEntity<Void> deleteUser(@PathVariable("userId") String userId) {
		userService.deleteUser(userId);
		return ResponseEntity.accepted().build();
	}

	@GetMapping("/users")
	ResponseEntity<List<UserDTOSkipPassword>> getAllUsers() {
		System.out.println("getting all the users");
		List<UserDTOSkipPassword> userDTOList = userService.getAllUsers();
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "returning all users");
		headers.add("desc", "users in the database");
		ResponseEntity<List<UserDTOSkipPassword>> responseEntity = new ResponseEntity<List<UserDTOSkipPassword>>(userDTOList, headers, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/users/{userId}")
	ResponseEntity<UserDTOSkipPassword>  getUserById(@PathVariable("userId") String userId) {
		UserDTOSkipPassword userDTO = userService.getUserById(userId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "returning user by Id");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(userDTO);
	}
	
	@PutMapping("/users/{userId}/resetPassword")
	ResponseEntity<Void>  updatePassword(@RequestBody UserDTO userDTO, @PathVariable("userId") String userId) {
		userDTO.setUserId(userId);
		userService.updatePassword(userDTO);
		AccessLog accessLog = new AccessLog();
		accessLog.setUserId(userDTO.getUserId());
		accessLog.setActivityType(ActivityType.RESETPASSWORD);
		accessLog.setLogTimestamp(LocalDateTime.now());
		accessLog.setSuccessStatus(true);
		accessLog.setNoOfAttempts(1);
		logService.addEntry(accessLog);
		return ResponseEntity.accepted().build();
		
	}
	
	// url: http://localhost:8080/deal-api/users/getUsersByAge?ageFrom=18&ageTo=50
	
	@GetMapping("/users/getUsersByAge")
	ResponseEntity<List<UserDTOSkipPassword>> getUsersByAge(@RequestParam("ageFrom") int ageFrom, @RequestParam("ageTo") int ageTo) {
		System.out.println("getting all the users in the specified age range");
		List<UserDTOSkipPassword> userDTOList = userService.getUsersByAge(ageFrom, ageTo);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "returning all users");
		headers.add("desc", "users in the database");
		ResponseEntity<List<UserDTOSkipPassword>> responseEntity = new ResponseEntity<List<UserDTOSkipPassword>>(userDTOList, headers, HttpStatus.OK);
		return responseEntity;
	}
	
	@PostMapping("/users/login")
	ResponseEntity<Void>  userLogin(@RequestBody UserLoginDTO userLoginDTO) {
		if(userService.userLogin(userLoginDTO))
		{
			AccessLog accessLog = new AccessLog();
			accessLog.setUserId(userService.getUserIdFromEmail(userLoginDTO.getEmail()));
			accessLog.setActivityType(ActivityType.LOGIN);
			accessLog.setLogTimestamp(LocalDateTime.now());
			accessLog.setSuccessStatus(true);
			accessLog.setNoOfAttempts(1);
			logService.addEntry(accessLog);
		return ResponseEntity.ok().build();
		}
		else
			return ResponseEntity.notFound().build();
	}
	
}