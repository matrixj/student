package com.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.bean.model.Mark;
import com.student.bean.model.Student;
import com.student.repository.StudentMessageControler;

public class ShowMarkServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		Student stu = (Student)req.getSession().getAttribute("Student");
		StudentMessageControler smc = new StudentMessageControler();
		Mark[] marks = smc.FindStudentMark(stu.getNo(),null,null);
		if(marks!=null){
			req.setAttribute("marks", marks);
		}
		smc.Close();
		req.getRequestDispatcher("ShowMark.jsp").forward(req, resp);
	}
	
}
