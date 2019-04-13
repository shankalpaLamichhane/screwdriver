package com.screwdriver.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils {
	public static Connection getMySQLConnection() 
			throws ClassNotFoundException, SQLException 
	{
		String hostName = "localhost";
		String dbName = "screwdriver";
		String userName = "root";
		String password = "root1234";
		return getMySQLConnection(hostName,dbName,userName,password);
	}

	private static Connection getMySQLConnection
	(String hostName, String dbName, String userName, String password)
			throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String connectionUrl = "jdbc:mysql://"+hostName+":3306/"+dbName;
		Connection conn = DriverManager.getConnection(connectionUrl,userName,password);
		return conn;
	}
}
