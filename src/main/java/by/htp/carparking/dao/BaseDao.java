package by.htp.carparking.dao;

import java.sql.SQLException;
import java.util.List;

import by.htp.carparking.domain.Entity;

public interface BaseDao<T extends Entity>{

	void create(T entity) throws SQLException;
	
	T read(int id) throws SQLException;
	
	List<T> readAll() throws SQLException;
	
	void update(T entity) throws SQLException;
	
	void delete(int id) throws SQLException;
	
}
