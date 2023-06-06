package com.simeioprepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreInsertScanDemo {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@192.168.18.40:1521:ASCEND";
		String username = "kkolluru";
		String password = "Simeio@2023";
		String sql = "insert into movie values(?,?,?,?)";
		
		sql = "insert into movie values(?,movie_id_seq.nextval,?,?)";
	
	
		try( Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement	preparedStatement = connection.prepareStatement(sql);
				Scanner sc = new Scanner(System.in);) {
			
			for(int i = 0; i < 2 ; i++) {
			
			System.out.println("Enter movie title");
			String movieTitle = sc.nextLine();
			System.out.println("Enter genre");
			String genre = sc.nextLine();
			System.out.println("Enter language");
			String language = sc.nextLine();
			
			preparedStatement.setString(1, movieTitle);
			preparedStatement.setString(2, genre);
			preparedStatement.setString(3, language);
			System.out.println(preparedStatement.execute());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
