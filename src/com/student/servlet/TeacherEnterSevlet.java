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
 * Servlet implementation class TeacherEnterSevlet
 */
@WebServlet("/TeacherEnterSevlet")
public class TeacherEnterSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherEnterSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd= request.getRequestDispatcher("/CreateClass.jsp");
      
        rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String grade = request.getParameter("Grade");
		String _class = request.getParameter("Class");
		String major = request.getParameter("Major");
		TeacherEnterHandle teacherEn = new TeacherEnterHandle();
		if(!teacherEn.isExist(grade, _class, major)){
              RequestDispatcher rd= request.getRequestDispatcher("/TeacherEntering.jsp");
              request.setAttribute("isRight", "error");
              rd.forward(request, response);
		}
		else{
			RequestDispatcher rd= request.getRequestDispatcher("/TeacherEntering.jsp");
            request.setAttribute("isRight", "right");
            request.setAttribute("Grade", grade);
            request.setAttribute("Class", _class);
            request.setAttribute("Major", major);
            rd.forward(request, response);
			
		}
		
	}

}
