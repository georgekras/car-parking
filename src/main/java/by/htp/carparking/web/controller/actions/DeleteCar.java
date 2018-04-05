package by.htp.carparking.web.controller.actions;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import by.htp.carparking.dao.DAO;
import by.htp.carparking.web.controller.FormUtil;

public class DeleteCar {

	public static void deleteCar(HttpServletRequest request) throws SQLException {
		DAO.getDAO().carDAO.delete(FormUtil.getInt(request, "delete"));
	}
}
