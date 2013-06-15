package com.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginPageServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String flag = req.getParameter("flag");
		if(flag!=null){
			if(flag.equals("1")){
				req.getRequestDispatcher("LoginPage.jsp?flag=1").forward(req, resp);
			}
			else{
				req.getRequestDispatcher("LoginPage.jsp?flag=0").forward(req, resp);
			}
		}
		else{
			req.getRequestDispatcher("LoginPage.jsp").forward(req, resp);
		}
	}
}
