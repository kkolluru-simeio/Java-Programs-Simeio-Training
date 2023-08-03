package com.groupon.utils;

public class CartQueries {
	
	public static final String CREATEQUERY = "create table cart (dealId number, userId varchar(6), primary key(dealId, userId), foreign key(dealId) references deal(dealId) ON DELETE CASCADE,  foreign key(userId) references dealUser(userId)ON DELETE CASCADE) ";
	
	public static final String INSERTQUERY = "insert into cart(dealId , userId) values(?,?)";
	
	public static final String DELETEQUERY = "delete from cart where dealId=? and userId=?";
	
	public static final String QUERYBYUSERID = "select * from deal d where d.dealId in (select dealId from cart where userId = ?)";
	
	public static final String QUERYDROPTABLE = "BEGIN\r\n"
			+ "   EXECUTE IMMEDIATE 'DROP TABLE cart';\r\n"
			+ "EXCEPTION\r\n"
			+ "   WHEN OTHERS THEN\r\n"
			+ "      IF SQLCODE != -942 THEN\r\n"
			+ "         RAISE;\r\n"
			+ "      END IF;\r\n"
			+ "END;";
	
}
