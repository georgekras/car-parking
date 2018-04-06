package by.htp.carparking.web.actions;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public interface BaseAction {
	
	String executeAction(HttpServletRequest request) throws IOException, SQLException;

}
