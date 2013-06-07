package com.student.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.student.CommonData;

public class InitServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		ServletConfig config = getServletConfig();
		CommonData.Database.DBDriver = config.getInitParameter("DBDriver");
		CommonData.Database.DBConnStr = config.getInitParameter("DBConnStr");
		CommonData.Database.user = config.getInitParameter("user");
		CommonData.Database.password = config.getInitParameter("password");
	}

}
