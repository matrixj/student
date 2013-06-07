package com.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.print.attribute.standard.DateTimeAtCreation;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.repository.*;

public class LoginServlet extends HttpServlet{

	/**
	 * 用于验证登陆信息
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		String ID = req.getParameter("ID");
		String password = req.getParameter("password");
		String flag = req.getParameter("flag");
		PrintWriter out = resp.getWriter();
		if(flag.equals("0")){
			StudentMessageControler smc = new StudentMessageControler();
			if(smc.SearchStudent(ID,password,null,null,null)){
				out.print("success");
			}
			else{
				out.print("fail");
			}
		}
		else{
			TeacherMessageControler tmc = new TeacherMessageControler();
			if(tmc.SearchTeacher(ID,null,password)){
				out.print("success");
				out.print("fail");
			}
		}
	}
}