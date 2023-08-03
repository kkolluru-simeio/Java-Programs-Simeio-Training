package com.groupon.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;

import com.groupon.model.AccessLog;
import com.groupon.model.ActivityType;
import com.groupon.model.Deal;

public class LogMapper implements RowMapper<AccessLog>{

	@Override
	public AccessLog mapRow(ResultSet rs, int rowNum) throws SQLException {
		AccessLog accessLog = new AccessLog();
		accessLog.setAccessLogId(rs.getInt("accessLogId"));
		accessLog.setUserId(rs.getString("userId"));
		accessLog.setActivityType(ActivityType.valueOf(rs.getString("activityType")));
		accessLog.setLogTimestamp(rs.getTimestamp("logTimestamp").toLocalDateTime());
		accessLog.setSuccessStatus(rs.getInt("successStatus") == 0 ? false:true);
		accessLog.setNoOfAttempts(rs.getInt("noOfAttempts"));
		return accessLog;
		
	}

}
