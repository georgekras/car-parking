package by.htp.carparking.dao;

import by.htp.carparking.domain.Order;

public interface OrderDao extends BaseDao<Order> {

	void insertNewOrder(int user_id, int car_id);

}
