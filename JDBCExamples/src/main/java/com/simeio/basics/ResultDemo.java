package com.simeio.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ResultDemo {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@192.168.18.40:1521:ASCEND";
		String username = "kkolluru";
		String password = "Simeio@2023";
		try (Connection connection = DriverManager.getConnection(url, username, password);
				Statement statement = connection.createStatement();) {

			String sql = "select * from book";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String title = rs.getString("title");
				int id = rs.getInt("bookId");
				String author = rs.getString("author");
				double price = rs.getDouble("price");
				System.out.println(title + "\t" + id + "\t" + author + "\t" + price + "\t");
			}
			rs = statement.executeQuery(sql);
			Book book = new Book();
			while (rs.next()) {
				book.setTitle(rs.getString("title"));
				book.setBookId(rs.getInt("bookId"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getDouble("price"));
				System.out.println(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
