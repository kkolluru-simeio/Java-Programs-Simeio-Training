package com.simeioprepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreUpdateDemo {
	
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@192.168.18.40:1521:ASCEND";
		String username = "kkolluru";
		String password = "Simeio@2023";
		String sql = "insert into movie values(?,?,?,?)";
		
		sql = "update movie set genre=? where genre=? or genre=initcap(?) or genre=lower(?) or genre = upper(?)";
	
	
		try( Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement	preparedStatement = connection.prepareStatement(sql);
				Scanner sc = new Scanner(System.in);) {
			
			System.out.println("Enter new genre title");
			String newGenre = sc.nextLine();
			System.out.println("Enter old genre");
			String oldGenre = sc.nextLine();

			preparedStatement.setString(1, newGenre);
			preparedStatement.setString(2, oldGenre);
			preparedStatement.setString(3, oldGenre);
			preparedStatement.setString(4, oldGenre);
			preparedStatement.setString(5, oldGenre);
			
			System.out.println(preparedStatement.execute());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
