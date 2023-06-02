package com.doctorapp.util;

public class Queries {
	
	public static final String CREATEQUERY = "create table doctor (doctorName varchar(20),doctorId number primary key ,speciality varchar(30),"

+ "experience number, fees real,startTime timestamp, endTime timestamp)";
	
	public static final String INSERTQUERY = "insert into doctor(doctorName ,doctorId ,speciality ,"

+ "experience , fees ,startTime , endTime ) values(?,DOCTOR_SEQ.nextval,?,?,?,?,?)";
	
	public static final String UPDATEQUERY = "update doctor set fees = ? where doctorId=?";
	
	public static final String DELETEQUERY = "delete from doctor where doctorId=?";
	
	public static final String QUERYALL = "select * from Doctor";
	
	public static final String QUERYBYID = "select * from Doctor where doctorId=?";
	
	public static final String QUERYBYSPECIALITY = "select * from Doctor where speciality=?";

	public static final String QUERYBYSPECIALITYEXP = "select * from Doctor where speciality=? and experience >=?";
	
	public static final String QUERYBYSPECIALITYFEES = "select * from Doctor where speciality=? and fees <=?";
	
	public static final String QUERYBYAVAILABILITY = "select * from Doctor where speciality=? and ? between startTime and endTime";
	
	public static final String CREATESEQ =" CREATE SEQUENCE DOCTOR_SEQ START WITH 1 INCREMENT BY 1";
	
	public static final String QUERYDROPTABLE = "DROP TABLE DOCTOR";
	
	public static final String QUERYDROPSEQ = "DROP SEQUENCE DOCTOR_SEQ";

}
