package by.htp.carparking.service;

import java.sql.SQLException;
import java.util.List;
import by.htp.carparking.domain.Car;

public interface CarService {

	List<Car> getCarsList() throws SQLException;
	void createCar(Car car) throws SQLException;
	Car readCar(int id) throws SQLException;
	void updateCar(Car car) throws SQLException;
	void deleteCar(int id) throws SQLException;
}
