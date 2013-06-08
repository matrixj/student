package com.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.repository.*;

/**
 * 用于验证登陆信息
 */
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		req.setCharacterEncoding("gb2312");
		resp.setContentType("text/html; charset=gb2312");
		String ID = req.getParameter("ID");
		String password = req.getParameter("password");
		String flag = req.getParameter("flag");
		PrintWriter out = resp.getWriter();
		if(flag.equals("0")){
			StudentMessageControler smc = new StudentMessageControler();
			if(smc.SearchStudent(ID,password,null,null,null)){
				req.getSession().setAttribute("No", ID);
				req.getRequestDispatcher("").forward(req, resp);
			}
			else{
				out.print("fail");
			}
		}
		else{
			TeacherMessageControler tmc = new TeacherMessageControler();
			if(tmc.SearchTeacher(ID,null,password)){
				req.getSession().setAttribute("No", ID);
				req.getRequestDispatcher("").forward(req, resp);
			}
			else{
				out.print("fail");
			}
		}
	}
}