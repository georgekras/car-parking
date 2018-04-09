package by.htp.carparking.service.impl;

import by.htp.carparking.dao.DaoFactory;
import by.htp.carparking.dao.OrderDao;
import by.htp.carparking.service.OrderService;

public class OrderServiceImpl implements OrderService{

	private OrderDao orderDao = (OrderDao) DaoFactory.getOrderDao();
	
	@Override
	public void orderCar(int user_id, int car_id) {

		orderDao.insertNewOrder(user_id, car_id);
		
		
	}

}
