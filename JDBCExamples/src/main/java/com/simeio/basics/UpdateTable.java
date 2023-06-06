package com.simeio.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTable {
	
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@192.168.18.40:1521:ASCEND";
		String username = "kkolluru";
		String password = "Simeio@2023";
		try(Connection connection = DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
				Scanner sc = new Scanner(System.in);) {

			System.out.println("Enter book id to update");
			int bookId = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter updated price");
			double price = Double.parseDouble(sc.nextLine());
			String sql = "update book set price = "+ price + " where bookId = "+ bookId;
			System.out.println(sql);
			System.out.println(statement.execute(sql));
			System.out.println("row updated" );		
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
