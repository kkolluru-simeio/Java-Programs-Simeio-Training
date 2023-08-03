package com.groupon.service;

import java.util.List;

import com.groupon.exceptions.DealNotFoundException;
import com.groupon.exceptions.LogNotFoundException;
import com.groupon.model.AccessLog;

public interface ILogService {

	void addEntry(AccessLog accessLog);

	void deleteEntry(int accessLogId);

	List<AccessLog> getAllLogs() throws LogNotFoundException;
	
	List<AccessLog> getLogsByUser(String userId) throws LogNotFoundException;
	
	void updateAttemptCount(int accessLogId, int noOfAttempts);

}
