package com.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.bean.model.Student;
import com.student.repository.StudentMessageControler;

public class ModifyPwdServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		Student stu = (Student)req.getSession().getAttribute("Student");
		String oldPwd = req.getParameter("oldPassword");
		String newPwd = req.getParameter("newPassword");
		String conPwd = req.getParameter("confirmPassword");
		if(!stu.getPassword().equals(oldPwd)){
			req.getRequestDispatcher("ModifyStudentPwd.jsp?flag=1").forward(req, resp);
		}
		else if(!newPwd.equals(conPwd)){
			req.getRequestDispatcher("ModifyStudentPwd.jsp?flag=2").forward(req, resp);
		}
		else{
			StudentMessageControler smc = new StudentMessageControler();
			smc.UpdateStudent(stu.getNo(), newPwd);
			req.getRequestDispatcher("ModifyStudentPwd.jsp?flag=3").forward(req, resp);
		}
	}
}
