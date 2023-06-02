package com.doctorapp.util;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	static Connection connection;
	
	static {
		Connection connection = DbConnection.openConnection();
		 Statement statement;
			try {
				System.out.println("inside static block");
				statement = connection.createStatement();
				statement.execute(Queries.QUERYDROPTABLE);
				statement.execute(Queries.CREATEQUERY);
				System.out.println("create table comleted");
				statement.execute(Queries.QUERYDROPSEQ);
				 statement.execute(Queries.CREATESEQ);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		DbConnection.closeConnection();
	}

	public static Connection openConnection() {
		String url = "jdbc:oracle:thin:@192.168.18.40:1521:ASCEND";
		String username = "kkolluru";
		String password = "Simeio@2023";
		try {
			 connection = DriverManager.getConnection(url, username, password);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	
	public static void closeConnection() {
		try {
			if(connection!=null)
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
