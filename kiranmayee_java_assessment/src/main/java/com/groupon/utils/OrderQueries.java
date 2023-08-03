package com.groupon.utils;

public class OrderQueries {
	
	public static final String CREATEQUERY = "create table orders (dealId number, userId varchar(6), availabilityStatus char check (availabilityStatus in (0,1)), primary key(dealId, userId),  foreign key(dealId) references deal(dealId) ON DELETE CASCADE,  foreign key(userId) references dealUser(userId) ON DELETE CASCADE)";
	
	public static final String INSERTQUERY = "insert into orders(dealId , userId, availabilityStatus) values(?,?,?)";
	
	public static final String UPDATEQUERY = "update orders set availabilityStatus = ? where dealId =? and userId = ?";
	
	public static final String DELETEQUERY = "delete from orders where dealId=? and userId=?";
	
	public static final String QUERYBYUSERID = "select * from deal d where d.dealId in (select dealId from orders where userId = ?)";
	
	public static final String QUERYUNUSEDDEALSBYUSERID = "select * from deal d where d.dealId in (select dealId from orders where userId = ? and availabilityStatus = ?)";

	public static final String QUERYDROPTABLE = "BEGIN\r\n"
			+ "   EXECUTE IMMEDIATE 'DROP TABLE orders';\r\n"
			+ "EXCEPTION\r\n"
			+ "   WHEN OTHERS THEN\r\n"
			+ "      IF SQLCODE != -942 THEN\r\n"
			+ "         RAISE;\r\n"
			+ "      END IF;\r\n"
			+ "END;";
	
}
