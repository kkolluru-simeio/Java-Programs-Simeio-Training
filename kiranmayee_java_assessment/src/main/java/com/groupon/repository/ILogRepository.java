package com.groupon.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.groupon.model.AccessLog;

public interface ILogRepository {

	void addEntry(AccessLog accessLog);

	void deleteEntry(int accessLogId);

	List<AccessLog> findAllLogs();

	List<AccessLog> findLogsByUser(String userId);


}
