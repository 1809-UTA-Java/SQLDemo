package com.revature.JDBCDemo2.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	public static Connection getConnection() throws SQLException, IOException {
		//String url = "jdbc:oracle:thin:@192.168.56.105:1521:xe";
		//String username = "zoo";
		//String password = "p4ssw0rd";

		Properties prop = new Properties();
		InputStream in = new FileInputStream("connection.properties");
		prop.load(in);
		
		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		return DriverManager.getConnection(
			prop.getProperty("url"), 
			prop.getProperty("username"), 
			prop.getProperty("password")
		);
	}
}
