package com.groupon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.groupon.exceptions.DealNotFoundException;
import com.groupon.exceptions.LogNotFoundException;
import com.groupon.model.AccessLog;
import com.groupon.model.Deal;
import com.groupon.repository.ILogRepository;

@Component
public class LogServiceImpl implements ILogService {

	@Autowired
	ILogRepository logRepository;
	
	@Autowired
	IUserService userService;

	@Override
	public void addEntry(AccessLog accessLog) {
		logRepository.addEntry(accessLog);
		
	}

	@Override
	public void deleteEntry(int accessLogId) {
		logRepository.deleteEntry(accessLogId);
		
	}

	@Override
	public List<AccessLog> getAllLogs() throws LogNotFoundException {
		List<AccessLog> logList = logRepository.findAllLogs();
		if (logList.isEmpty())
			throw new LogNotFoundException("No logs found in db");
		return logList;
	}

	@Override
	public List<AccessLog> getLogsByUser(String userId) throws LogNotFoundException {
		List<AccessLog> logList = logRepository.findLogsByUser(userId);
		if (logList.isEmpty())
			throw new LogNotFoundException("No logs found in db for user " + userId);
		return logList;
	}

	@Override
	public void updateAttemptCount(int accessLogId, int noOfAttempts) {
		// TODO Auto-generated method stub
		
	}



}
