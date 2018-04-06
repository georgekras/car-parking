package by.htp.carparking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.carparking.dao.CarDao;
import by.htp.carparking.dbhelber.DBConnectionHelper;
import by.htp.carparking.domain.Car;

public class CarDaoDBImpl implements CarDao {

	@Override
	public void create(Car entity) throws SQLException {
		Connection connection = DBConnectionHelper.connect();
		try {
			String insert = "INSERT INTO `car` (`Brand`, `Model`) VALUES (?, ?);";
			PreparedStatement preparedStatement = connection.prepareStatement(insert,
					PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, entity.getBrand());
			preparedStatement.setString(2, entity.getModel());
			int recCount = preparedStatement.executeUpdate();
			if (recCount == 1) {
				ResultSet keys = preparedStatement.getGeneratedKeys();
				if (keys.next()) {
					int ID = keys.getInt(1);
					entity.setId(ID);
				}
			}
		} finally {
			DBConnectionHelper.disconnect(connection);
		}
	}

	@Override
	public Car read(int id) throws SQLException {
		Connection connection = DBConnectionHelper.connect();
		try {
			String insert = "Select * FROM car WHERE id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(insert);
			ResultSet result = preparedStatement.executeQuery();
			if (result.next()) {
				Car car = new Car(result.getInt("ID"), result.getString("Brand"), result.getString("Model"));
				return car;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnectionHelper.disconnect(connection);
		}
		return null;
	}

	@Override
	public List<Car> readAll() throws SQLException {
		List<Car> list = new ArrayList<>();
		Connection connection = DBConnectionHelper.connect();
		Statement statement = connection.createStatement();
		String sql = "SELECT * from car ;";
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			Car car = new Car(rs.getInt("ID"), rs.getString("Brand"), rs.getString("Model"));
			list.add(car);
		}
		return list;
	}

	@Override
	public void update(Car entity) throws SQLException {
		Connection connection = DBConnectionHelper.connect();
		try {
			String set = "UPDATE car SET Brand=?, Model=? WHERE ID=?;";
			PreparedStatement preparedStatement = connection.prepareStatement(set);
			preparedStatement.setString(1, entity.getBrand());
			preparedStatement.setString(2, entity.getModel());
			preparedStatement.setInt(3, entity.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnectionHelper.disconnect(connection);
		}
	}

	@Override
	public void delete(int id) throws SQLException {
		Connection connection = DBConnectionHelper.connect();
		try {
			String query = "DELETE FROM car WHERE ID=?;";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnectionHelper.disconnect(connection);
		}
	}

}
