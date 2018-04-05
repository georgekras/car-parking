package by.htp.carparking.web.controller;

import javax.servlet.http.HttpServletRequest;

public class FormUtil {

    public static boolean isPost(HttpServletRequest request){
        return request.getMethod().toUpperCase().equals("POST");
    }

    public static int getInt(HttpServletRequest request, String paramName){
        String value = request.getParameter(paramName);
        return Integer.parseInt(value);
    }

    public static double getDouble(HttpServletRequest request, String paramName){
        String value = request.getParameter(paramName);
        return Double.parseDouble(value);
    }
}
