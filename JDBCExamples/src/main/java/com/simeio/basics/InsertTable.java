package com.simeio.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTable {
	
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@192.168.18.40:1521:ASCEND";
		String username = "kkolluru";
		String password = "Simeio@2023";
		try(Connection connection = DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
				Scanner sc = new Scanner(System.in);) {

			System.out.println("Enter book title");
			String bookTitle = sc.nextLine();
			System.out.println("Enter book id");
			int bookId = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter author");
			String author = sc.nextLine();
			System.out.println("Enter price");
			double price = Double.parseDouble(sc.nextLine());
			String sql = "insert into book values(upper('"+bookTitle+"'),"+bookId +", lower('"+author+"'), " + price +")";
			System.out.println(sql);
			System.out.println(statement.execute(sql));
			System.out.println("row inserted" );		
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
