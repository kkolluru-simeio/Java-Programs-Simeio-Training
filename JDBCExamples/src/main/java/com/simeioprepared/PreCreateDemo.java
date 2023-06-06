package com.simeioprepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PreCreateDemo {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@192.168.18.40:1521:ASCEND";
		String username = "kkolluru";
		String password = "Simeio@2023";
		String sql = "create table movie(movieName varchar(20), movieId number primary key, genre varchar(20), language varchar(20))";
		
		try(Connection connection = DriverManager.getConnection(url, username, password);
			PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			
			System.out.println(preparedStatement.execute());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
