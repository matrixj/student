package com.student.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {
	
	private String loginPage;
	private String loginServlet;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpSession session = req.getSession();
		if(session.getAttribute("Student") != null || 
				session.getAttribute("Teacher") != null || 
				req.getServletPath().equals("/" + loginPage)
				|| req.getServletPath().equals("/" + loginServlet)) {
			arg2.doFilter(arg0, arg1);
		}
		else {
			HttpServletResponse resp = (HttpServletResponse) arg1;
			resp.sendRedirect(loginPage);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		loginPage = "loginPage";
		loginServlet = "loginServlet";
	}

}
