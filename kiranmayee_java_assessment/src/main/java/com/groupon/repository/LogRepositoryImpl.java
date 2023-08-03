package com.groupon.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.groupon.model.AccessLog;
import com.groupon.utils.LogQueries;
@Component
public class LogRepositoryImpl implements ILogRepository {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void addEntry(AccessLog accessLog) {
		String sql = LogQueries.INSERTQUERY;
		Object[] logArray = {accessLog.getUserId(), accessLog.getActivityType().name(), Timestamp.valueOf(accessLog.getLogTimestamp()), accessLog.getSuccessStatus() ? 1 : 0, accessLog.getNoOfAttempts() };
		jdbcTemplate.update(sql, logArray);
	}

	@Override
	public void deleteEntry(int accessLogId) {
		jdbcTemplate.update(LogQueries.DELETEQUERY, accessLogId);

	}

	@Override
	public List<AccessLog> findAllLogs() {
		return jdbcTemplate.query(LogQueries.QUERYALLLOGS, new LogMapper());
		
	}

	@Override
	public List<AccessLog> findLogsByUser(String userId) {
		return jdbcTemplate.query(LogQueries.QUERYLOGSBYUSER, new LogMapper(), userId);
	}

}
