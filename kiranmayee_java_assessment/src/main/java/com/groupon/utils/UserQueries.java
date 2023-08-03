package com.groupon.utils;

public class UserQueries {
	
	public static final String CREATEQUERY = "create table dealUser (userId varchar(6) primary key, firstName varchar(20) ,"

+ "middleName varChar(20), lastName varChar(20), email varchar(50) not null, dateOfBirth Date, securityQuestion varchar(100), securityAnswer varchar(100), city varchar(20), password varchar(200), unique(email) )";
	
	public static final String INSERTQUERY = "insert into dealUser(userId, firstName ,"
		
			+ "middleName ,lastName , email , dateOfBirth , securityQuestion , securityAnswer , city, password ) values(?,?,?,?,?,?,?,?,?,?)";
	
	public static final String UPDATEQUERY = "update dealUser set firstName =? ,middleName =?, lastName =?, "
			+"email = ?, dateOfBirth = ?, securityQuestion = ?, securityAnswer = ?, city = ?, password = ? where userId=?";

	public static final String UPDATEPASSWORDQUERY = "update dealUser set password = ? where userId=?";
	
	public static final String DELETEQUERY = "delete from dealUser where userId=?";
	
	public static final String QUERYALL = "select * from dealUser";
	
	public static final String QUERYBYID = "select * from dealUser where userId=?";

	public static final String QUERYBYDOBRANGE = "select * from dealUser where dateOfBirth > ? and dateOfBirth < ?";

	public static final String GETPASSWORDQUERY = "select password from dealUser where email = ? ";
	
	public static final String GETUSERIDFROMEMAIL = "select userId from dealUser where email = ?";
	
	public static final String QUERYDROPTABLE = "BEGIN\r\n"
			+ "   EXECUTE IMMEDIATE 'DROP TABLE dealUser';\r\n"
			+ "EXCEPTION\r\n"
			+ "   WHEN OTHERS THEN\r\n"
			+ "      IF SQLCODE != -942 THEN\r\n"
			+ "         RAISE;\r\n"
			+ "      END IF;\r\n"
			+ "END;";
	
}
