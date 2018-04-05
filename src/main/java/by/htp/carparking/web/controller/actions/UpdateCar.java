package by.htp.carparking.web.controller.actions;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import by.htp.carparking.dao.DAO;
import by.htp.carparking.domain.Car;
import by.htp.carparking.web.controller.FormUtil;

public class UpdateCar {

	public static void editCar(HttpServletRequest request) throws SQLException {
		int id = FormUtil.getInt(request, "ID");
		String brand = request.getParameter("Brand");
		String model = request.getParameter("Model");
		Car car = new Car(id, brand, model);
		DAO.getDAO().carDAO.update(car);
	}
}
