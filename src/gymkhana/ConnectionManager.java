/* The aim of software is to provide an automated portal for gymkhana at IIT-Guwahati
    Copyright (C) 2013  Arihant Sethia

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
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