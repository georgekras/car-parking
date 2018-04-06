package by.htp.carparking.service.impl;

import java.sql.SQLException;
import java.util.List;

import by.htp.carparking.dao.CarDao;
import by.htp.carparking.dao.impl.CarDaoDBImpl;
import by.htp.carparking.domain.Car;
import by.htp.carparking.service.CarService;

public class CarServiceImpl implements CarService {

	private CarDao carDao = new CarDaoDBImpl();
	
	@Override
	public List<Car> getCarsList() throws SQLException {
		return carDao.readAll();
	}

	@Override
	public void createCar(Car car) throws SQLException {
		carDao.create(car);
		
	}

	@Override
	public Car readCar(int id) throws SQLException {
		return carDao.read(id);
	}

	@Override
	public void updateCar(Car car) throws SQLException {
		carDao.update(car);
		
	}

	@Override
	public void deleteCar(int id) throws SQLException {
		carDao.delete(id);
	}
	
	

}
