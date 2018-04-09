package by.htp.carparking.web.actions.impl;

import static by.htp.carparking.web.util.WebConstantDeclaration.*;
import static by.htp.carparking.web.util.HttpRequestParamValidator.*;
import static by.htp.carparking.web.util.HttpRequestParamFormatter.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.carparking.service.OrderService;
import by.htp.carparking.service.ServiceFactory;
import by.htp.carparking.web.actions.BaseAction;

public class OrderCarAction implements BaseAction {

	// TODO to IoC
	private OrderService orderService = ServiceFactory.getOrderService();

	@Override
	public String executeAction(HttpServletRequest request) {
		String car_id = request.getParameter(REQUEST_PARAM_CAR_ID);
		String user_id = request.getParameter(REQUEST_PARAM_USER_ID);

		validateRequsetParamNotNull(car_id, user_id);

		orderService.orderCar(formatString(user_id), formatString(car_id));

		request.setAttribute(REQUEST_MSG_SUCCESS, "The car was ordered succesfully.");

		return PAGE_USER_MAIN;
	}

}
