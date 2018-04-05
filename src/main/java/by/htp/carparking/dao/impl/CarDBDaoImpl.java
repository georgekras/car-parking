package by.htp.carparking.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import by.htp.carparking.dao.BaseDao;
import by.htp.carparking.dbhelber.DBConnectionHelper;
import by.htp.carparking.domain.Car;

public class CarDBDaoImpl implements BaseDao<Car> {

	@Override
	public void create(Car entity) throws SQLException {
		try (Connection connection = DBConnectionHelper.connect(); 
				Statement statement = connection.createStatement()) {
			String insert = String.format("INSERT INTO `car` (`Brand`, `Model`) VALUES ('%s','%s');",
			entity.getBrand(), entity.getModel());
			int recCount = statement.executeUpdate(insert, Statement.RETURN_GENERATED_KEYS);
			if (recCount == 1) {
				ResultSet keys = statement.getGeneratedKeys();
				if (keys.next()) {
					int ID = keys.getInt(1);
					entity.setId(ID);
				}
			}
		}
	}

	@Override
	public Car read(int id) throws SQLException {
		try (Connection connection = DBConnectionHelper.connect();
				Statement statement = connection.createStatement()
		){
			String insert = String.format("Select * FROM car WHERE id='%d'", id);
			ResultSet result = statement.executeQuery(insert);
			if (result.next()) {
				Car car = new Car(id);
				car.setBrand(result.getString("Brand"));
				car.setModel(result.getString("Model"));
				return car;
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
			Car car = new Car(
					rs.getInt("ID"), 
					rs.getString("Brand"), 
					rs.getString("Model"));
			list.add(car);
		}
		return list;
	}

	@Override
	public void update(Car entity) throws SQLException {
		try (Connection connection = DBConnectionHelper.connect();
				Statement statement = connection.createStatement()
		){
			String set = String.format("UPDATE car SET Brand='%s', Model='%s' WHERE id='%d';", entity.getBrand(), 
					entity.getModel(), entity.getId());
			statement.executeUpdate(set);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) throws SQLException {
		try (Connection connection = DBConnectionHelper.connect();
				Statement statement = connection.createStatement()
		){
			String query = String.format("DELETE FROM car WHERE id='%d';", id);
	        statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
