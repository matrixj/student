package com.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.repository.*;
import com.student.bean.model.*;

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
			Student stu[] = smc.SearchStudent(ID,password,null,null,null);
			if(stu!=null){
				req.getSession().setAttribute("Student", stu[0]);
				smc.Close();
				req.getRequestDispatcher("home").forward(req, resp);
			}
			else{
				req.getRequestDispatcher("LoginPage.jsp?flag=0&uncorrect=用户名或密码不正确").forward(req, resp);
			}
		}
		else{
			TeacherMessageControler tmc = new TeacherMessageControler();
			Teacher tea[] = tmc.SearchTeacher(ID, null, password); 
			if(tea!=null){
				req.getSession().setAttribute("Teacher", tea[0]);
				tmc.Close();
				req.getRequestDispatcher("test.jsp").forward(req, resp);
			}
			else{
				req.getRequestDispatcher("LoginPage.jsp?flag=1&uncorrect=用户名或密码不正确").forward(req, resp);
			}
		}
	}
}