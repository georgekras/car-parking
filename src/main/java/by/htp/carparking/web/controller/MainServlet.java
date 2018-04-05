package by.htp.carparking.web.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.carparking.dao.DAO;
import by.htp.carparking.domain.Car;
import by.htp.carparking.web.controller.FormUtil;
import by.htp.carparking.web.controller.actions.CreateCar;
import by.htp.carparking.web.controller.actions.UpdateCar;
import by.htp.carparking.web.controller.actions.DeleteCar;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MainServlet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			process(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			process(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		if (FormUtil.isPost(request)) {
			if (request.getParameter("action").equals("create")) {
				CreateCar.addCar(request);
			}
			if (request.getParameter("action").equals("update")) {
				UpdateCar.editCar(request);
			}
			
		}
		if (request.getParameter("delete") != null) {
			DeleteCar.deleteCar(request);
		}
		List<Car> car = DAO.getDAO().carDAO.readAll();
		request.setAttribute("car", car);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/editcar.jsp");
        dispatcher.forward(request, response);

	}
	
}
