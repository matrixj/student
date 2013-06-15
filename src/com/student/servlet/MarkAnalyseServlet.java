package com.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.bean.model.Mark;
import com.student.repository.StudentMessageControler;

public class MarkAnalyseServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		StudentMessageControler smc = new StudentMessageControler();
		String Did = req.getParameter("department");
		String Sid = req.getParameter("subject");
		if(Did!=null&&Sid!=null){			
			if(Did.equals(""))Did=null;			
			if(Sid.equals("")){
				Sid=null;
			}
			else{
				req.setAttribute("flag", "1");
			}
			Mark[] marks = smc.FindStudentMark(null, Did, Sid);
			req.setAttribute("marks", marks);
		}
		req.getRequestDispatcher("MarkAnalysePage.jsp").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
}
