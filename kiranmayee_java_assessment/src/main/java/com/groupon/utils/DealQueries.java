package com.groupon.utils;

public class DealQueries {
	
	public static final String CREATEQUERY = "create table deal (dealId number primary key, outletId number ,"

+ "expiryDate timestamp, originalPrice real, discountedPrice real, category varchar(20), noOfPurchases number )";
	
	public static final String INSERTQUERY = "insert into deal(dealId ,outletId ,"

+ " expiryDate ,originalPrice , discountedPrice, category, noOfPurchases ) values(DEAL_SEQ.nextval,?,?,?,?,?,?)";
	
	public static final String UPDATEQUERY = "update deal set outletId = ?,  "
			
+" expiryDate =? ,originalPrice =?, discountedPrice =?, category = ?, noOfPurchases = ? where dealId=?";
	
	public static final String DELETEQUERY = "delete from deal where dealId=?";
	
	public static final String QUERYALL = "select * from deal";
	
	public static final String QUERYBYID = "select * from deal where dealId=?";
	
	public static final String QUERYBYCATEGORY = "select * from deal where category=?";
	
	public static final String QUERYBYDISCOUNTEDPRICE = "select * from deal order by discountedPrice asc";
	
	public static final String QUERYBYEXPIRYDATE = "select * from deal order by expiryDate asc";
	
	public static final String QUERYBYNOOFPURCHASES = "select * from deal order by noOfPurchases desc";
	
	public static final String CREATESEQ =" CREATE SEQUENCE DEAL_SEQ START WITH 1 INCREMENT BY 1";

	public static final String QUERYDROPTABLE = "BEGIN\r\n"
			+ "   EXECUTE IMMEDIATE 'DROP TABLE deal';\r\n"
			+ "EXCEPTION\r\n"
			+ "   WHEN OTHERS THEN\r\n"
			+ "      IF SQLCODE != -942 THEN\r\n"
			+ "         RAISE;\r\n"
			+ "      END IF;\r\n"
			+ "END;";
	
	public static final String QUERYDROPSEQ  = "BEGIN\r\n"
			+ "   EXECUTE IMMEDIATE 'DROP SEQUENCE DEAL_SEQ';\r\n"
			+ "EXCEPTION\r\n"
			+ "   WHEN OTHERS THEN\r\n"
			+ "      IF SQLCODE != -02289 THEN\r\n"
			+ "         RAISE;\r\n"
			+ "      END IF;\r\n"
			+ "END;";
	
}
