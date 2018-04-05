package by.htp.carparking.dao.impl;

import java.sql.SQLException;

import by.htp.carparking.dao.DAO;
import by.htp.carparking.domain.Car;

public class Runner {

	public static void main(String[] args) throws SQLException {
		Car car = new Car("Bmw", "x5");
		DAO.getDAO().carDAO.create(car);
		car.setBrand("adfafaf");
		DAO.getDAO().carDAO.update(car);
	}

}
