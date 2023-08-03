package com.groupon.model;

import java.time.LocalDateTime;

public class AccessLog {

	Integer accessLogId;
	String userId;
	ActivityType activityType;
	LocalDateTime logTimestamp;
	Boolean successStatus;
	Integer noOfAttempts;
	
	public AccessLog() {
		super();
	}

	public AccessLog(Integer accessLogId, String userId, ActivityType activityType, LocalDateTime logTimestamp,
			Boolean successStatus, Integer noOfAttempts) {
		super();
		this.accessLogId = accessLogId;
		this.userId = userId;
		this.activityType = activityType;
		this.logTimestamp = logTimestamp;
		this.successStatus = successStatus;
		this.noOfAttempts = noOfAttempts;
	}

	public Integer getAccessLogId() {
		return accessLogId;
	}

	public void setAccessLogId(Integer accessLogId) {
		this.accessLogId = accessLogId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public ActivityType getActivityType() {
		return activityType;
	}

	public void setActivityType(ActivityType activityType) {
		this.activityType = activityType;
	}

	public LocalDateTime getLogTimestamp() {
		return logTimestamp;
	}

	public void setLogTimestamp(LocalDateTime logTimestamp) {
		this.logTimestamp = logTimestamp;
	}

	public Boolean getSuccessStatus() {
		return successStatus;
	}

	public void setSuccessStatus(Boolean successStatus) {
		this.successStatus = successStatus;
	}

	public Integer getNoOfAttempts() {
		return noOfAttempts;
	}

	public void setNoOfAttempts(Integer noOfAttempts) {
		this.noOfAttempts = noOfAttempts;
	}

	@Override
	public String toString() {
		return "AccessLog [accessLogId=" + accessLogId + ", userId=" + userId + ", activityType=" + activityType
				+ ", logTimestamp=" + logTimestamp + ", successStatus=" + successStatus + ", noOfAttempts=" + noOfAttempts
				+ "]";
	}

	
	
	
}
