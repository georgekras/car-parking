package by.htp.carparking.dbhelber;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBInit {

	public static void main(String[] args) {
		initDB();
	}

	public static void initDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection connection = (Connection) DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/" + "?useUnicode=true&characterEncoding=UTF-8", "root", "")) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("DROP SCHEMA IF EXISTS `carparking` ;");
			statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `carparking` DEFAULT CHARACTER SET utf8 ;");
			statement.executeUpdate("USE `carparking` ;");
			statement.executeUpdate("DROP TABLE IF EXISTS `carparking`.`car` ;");
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS `carparking`.`car` (\n"
					+ "`ID` INT NOT NULL AUTO_INCREMENT,\n" + "`Brand` VARCHAR(45) NOT NULL,\n"
					+ "`Model` VARCHAR(45) NOT NULL,\n" + "PRIMARY KEY (`ID`))\n" + "ENGINE = InnoDB;");

			statement.executeUpdate("INSERT INTO `carparking`.`car` (`Brand`, `Model`) VALUES ('BMW', 'm5');");
			statement.executeUpdate("INSERT INTO `carparking`.`car` (`Brand`, `Model`) VALUES ('Mercedes', 's220');");

			System.out.println("Database initialized");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
