package by.htp.carparking.web.actions.impl;

import static by.htp.carparking.web.util.WebConstantDeclaration.*;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import by.htp.carparking.domain.Car;
import by.htp.carparking.service.CarService;
import by.htp.carparking.service.impl.CarServiceImpl;
import by.htp.carparking.web.actions.BaseAction;
import by.htp.carparking.web.controller.FormUtil;

public class CarUpdateAction implements BaseAction{

	private CarService carService = new CarServiceImpl();
	
	@Override
	public String executeAction(HttpServletRequest request) throws IOException, SQLException {
		if (FormUtil.isPost(request)) {
			Car car = new Car(
					FormUtil.getInt(request, "ID"),
					request.getParameter("Brand"),
					request.getParameter("Model")
					);
			carService.updateCar(car);
		}
		request.setAttribute(REQUEST_PARAM_CAR_LIST, carService.getCarsList());
		return PAGE_USER_CAR_UPDATE;
	}

}
