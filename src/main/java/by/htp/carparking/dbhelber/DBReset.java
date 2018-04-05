package by.htp.carparking.dbhelber;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBReset {

	public static void main(String[] args) {
		resetDB();
	}

	public static void resetDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection connection = (Connection) DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/" + "?useUnicode=true&characterEncoding=UTF-8", "root", "")) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("DROP SCHEMA IF EXISTS `carparking`;");

			System.out.println("Database reset");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
