package com.todo.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
	private static String jdbcURL = "jdbc:mysql://localhost:3306/db";
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "root";
	
	public static Connection getConnection() {
		
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}

}
