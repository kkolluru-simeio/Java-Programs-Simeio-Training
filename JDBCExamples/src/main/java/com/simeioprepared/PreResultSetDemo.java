package com.simeioprepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.simeio.basics.Book;

public class PreResultSetDemo {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@192.168.18.40:1521:ASCEND";
		String username = "kkolluru";
		String password = "Simeio@2023";
		String sql = "select * from movie";
		try (Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
			ResultSet rs = preparedStatement.executeQuery(sql);

			Movie movie = new Movie();
			while (rs.next()) {
				movie.setMovieName(rs.getString("movieName"));
				movie.setMovieId(rs.getInt("movieId"));
				movie.setGenre(rs.getString("genre"));
				movie.setLanguage(rs.getString("language"));
				System.out.println(movie);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql = "select * from movie where genre=?";
		try (Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

			String genre = "fun";
			preparedStatement.setString(1, genre);
			ResultSet rs = preparedStatement.executeQuery();
			Movie movie = new Movie();
			while (rs.next()) {
				movie.setMovieName(rs.getString("movieName"));
				movie.setMovieId(rs.getInt("movieId"));
				movie.setGenre(rs.getString("genre"));
				movie.setLanguage(rs.getString("language"));
				System.out.println(movie);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
