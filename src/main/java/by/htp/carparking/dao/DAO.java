package by.htp.carparking.dao;

import by.htp.carparking.dao.impl.CarDBDaoImpl;

public class DAO {
	
	private DAO() {}
	
	private static DAO instance;
	
	public final CarDBDaoImpl carDAO = new CarDBDaoImpl();
	
	public static DAO getDAO(){
        if (instance == null){
            synchronized (DAO.class){
                if (instance == null){
                    instance = new DAO();
                }
            }
        }
        return instance;
    }

}