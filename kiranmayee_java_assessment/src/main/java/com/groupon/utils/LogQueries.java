package com.groupon.utils;

public class LogQueries {
	
	public static final String CREATEQUERY = "create table accessLog (accessLogId number primary key," +
	
			" userId varchar(6), activityType varchar(20), logTimestamp timestamp," +
			
			" successStatus char check (successStatus in (0,1)) , " + 
			
			"noOfAttempts number, foreign key(userId) references dealUser(userId)) ";
	
	public static final String INSERTQUERY = "insert into accessLog(accessLogId ,userId , activityType, "
			
			+ "logTimestamp, successStatus,  noOfAttempts ) values(LOG_SEQ.nextVal , ?,?,?,?,?)";
	
	public static final String DELETEQUERY = "delete from accessLog where accessLogId=?";
	
	public static final String QUERYALLLOGS = "select * from accessLog";
	
	public static final String QUERYLOGSBYUSER = "select * from accessLog where userId=?";
	
	public static final String CREATESEQ =" CREATE SEQUENCE LOG_SEQ START WITH 1 INCREMENT BY 1";

	
	public static final String QUERYDROPTABLE = "BEGIN\r\n"
			+ "   EXECUTE IMMEDIATE 'DROP TABLE accessLog';\r\n"
			+ "EXCEPTION\r\n"
			+ "   WHEN OTHERS THEN\r\n"
			+ "      IF SQLCODE != -942 THEN\r\n"
			+ "         RAISE;\r\n"
			+ "      END IF;\r\n"
			+ "END;";
	public static final String QUERYDROPSEQ  = "BEGIN\r\n"
			+ "   EXECUTE IMMEDIATE 'DROP SEQUENCE LOG_SEQ';\r\n"
			+ "EXCEPTION\r\n"
			+ "   WHEN OTHERS THEN\r\n"
			+ "      IF SQLCODE != -02289 THEN\r\n"
			+ "         RAISE;\r\n"
			+ "      END IF;\r\n"
			+ "END;";
	
}
