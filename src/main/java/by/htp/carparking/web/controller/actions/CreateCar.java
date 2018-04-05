package by.htp.carparking.web.controller.actions;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import by.htp.carparking.dao.DAO;
import by.htp.carparking.domain.Car;

public class CreateCar {

	public static void addCar(HttpServletRequest request) throws SQLException {
		String brand = request.getParameter("Brand");
		String model = request.getParameter("Model");
		Car car = new Car(brand, model);
		DAO.getDAO().carDAO.create(car);
	}
	
}
