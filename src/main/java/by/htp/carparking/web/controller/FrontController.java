package by.htp.carparking.web.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.carparking.web.actions.ActionManager;
import by.htp.carparking.web.actions.BaseAction;

import static by.htp.carparking.web.util.WebConstantDeclaration.*;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			processRequest(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
		
		String action = request.getParameter(REQUEST_PARAM_ACTION);
		BaseAction baseAction = ActionManager.getAction(action);
		if (action != null) {
			String page = baseAction.executeAction(request);
			request.getRequestDispatcher(page).forward(request, response);
		} else {
			response.getWriter().println("Incorrect action");
		}
	}

}
