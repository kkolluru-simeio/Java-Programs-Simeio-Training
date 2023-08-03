package com.groupon.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupon.exceptions.LogNotFoundException;
import com.groupon.exceptions.UserNotFoundException;
import com.groupon.model.AccessLog;
import com.groupon.model.Deal;
import com.groupon.service.ILogService;

@RestController
@RequestMapping("/deal-api")
public class LogController {

	@Autowired
	ILogService logService;

	@GetMapping("/logs")
	ResponseEntity<List<AccessLog>> getAllLogs() {
		System.out.println("getting all the logs");
		List<AccessLog> logList = logService.getAllLogs();
		if (logList.size() == 0)
			throw new LogNotFoundException("empty log");
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "returning all logs in db");
		ResponseEntity<List<AccessLog>> responseEntity = new ResponseEntity<List<AccessLog>>(logList, headers, HttpStatus.OK);
		return responseEntity;
	}
	@GetMapping("/logs/{userId}")
	ResponseEntity<List<AccessLog>> getLogsByUser(@PathVariable("userId") String userId) {
		System.out.println("getting logs by user");
		List<AccessLog> logList = logService.getLogsByUser(userId);
		if (logList.size() == 0)
			throw new LogNotFoundException("no logs recorded for user " + userId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "returning all logs for the user");
		ResponseEntity<List<AccessLog>> responseEntity = new ResponseEntity<List<AccessLog>>(logList, headers, HttpStatus.OK);
		return responseEntity;
	}


}