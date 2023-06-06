package com.simeioprepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreInsertDemo {


	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@192.168.18.40:1521:ASCEND";
		String username = "kkolluru";
		String password = "Simeio@2023";
		String sql = "insert into movie values(?,?,?,?)";
		
	/*	try(Connection connection = DriverManager.getConnection(url, username, password);
			PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			
			preparedStatement.setString(1, "ABC");
			preparedStatement.setInt(2, 1);
			preparedStatement.setString(3, "Thriller");
			preparedStatement.setString(4, "Telugu");
			
			
			System.out.println(preparedStatement.execute());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
		
		sql = "create sequence movie_id_seq start with 101";
		
		try(Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				
				System.out.println(preparedStatement.execute());
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		sql = "insert into movie values(?,movie_id_seq.nextval,?,?)";
	
	
		try( Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement	preparedStatement = connection.prepareStatement(sql);) {
			preparedStatement.setString(1, "SED");
			preparedStatement.setString(2, "Comedy");
			preparedStatement.setString(3, "Hindi");
			System.out.println(preparedStatement.execute());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
