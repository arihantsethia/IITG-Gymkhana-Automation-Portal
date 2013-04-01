package gymkhana;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class ConnectionManager {

	static Connection con;
	static String url;
	static String driver = "com.mysql.jdbc.Driver";
	static String dbName = "gymkhana";
	static String username = "root", password = "";

	public static Connection getConnection() {
		url = "jdbc:mysql://localhost:3306/" + dbName;
		// assuming "DataSource" is your DataSource name
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Established");

		} catch (Exception e) {
			System.out.println("Connection not Established");
			e.printStackTrace();
		}

		return con;
	}

	public static void disconnect() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}