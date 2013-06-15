package com.student.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.student.repository.TeacherEnterHandle;

/**
 * Servlet implementation class CreateClassSevlet
 */
@WebServlet("/CreateClassSevlet")
public class CreateClassSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateClassSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTf-8");
		String _class = request.getParameter("_class");
		String major = request.getParameter("major");
		String grade = request.getParameter("grade");
		String Did   = request.getParameter("Did");
		TeacherEnterHandle teacherEn = new TeacherEnterHandle();
		if(teacherEn.isExist(grade, _class, major)){
			RequestDispatcher rd= request.getRequestDispatcher("/CreateClass.jsp");
			request.setAttribute("success", "NO");
	         rd.forward(request, response);
		}
		if(!teacherEn.isExist(grade, _class, major)){
			
			teacherEn.InsertClass(Integer.parseInt(Did), major, _class, grade);
			RequestDispatcher rd= request.getRequestDispatcher("/TeacherEntering.jsp");
			request.setAttribute("success", "Yes");
	         rd.forward(request, response);
		}
	}

}
