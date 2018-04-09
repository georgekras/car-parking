package by.htp.carparking.web.actions.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.carparking.service.OrderService;
import by.htp.carparking.service.ServiceFactory;
import by.htp.carparking.web.actions.BaseAction;

public class ReturnCarAction implements BaseAction {

	private OrderService orderService = ServiceFactory.getOrderService();

	@Override
	public String executeAction(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
