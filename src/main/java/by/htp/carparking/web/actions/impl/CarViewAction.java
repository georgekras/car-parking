package by.htp.carparking.web.actions.impl;

import static by.htp.carparking.web.util.WebConstantDeclaration.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.carparking.domain.Car;
import by.htp.carparking.service.CarService;
import by.htp.carparking.service.ServiceFactory;
import by.htp.carparking.web.actions.BaseAction;

public class CarViewAction implements BaseAction{

	private CarService carService = ServiceFactory.getCarService();
	
	@Override
	public String executeAction(HttpServletRequest request) throws IOException, SQLException {
		List<Car> cars = carService.getCarsList();
		request.setAttribute(REQUEST_PARAM_CAR_LIST, cars);
		return PAGE_USER_CAR_MAIN;
	}

}
