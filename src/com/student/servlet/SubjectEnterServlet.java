package com.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.student.repository.TeacherEnterHandle;

/**
 * Servlet implementation class SubjectEnter
 */
@WebServlet("/SubjectEnter")
public class SubjectEnterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectEnterServlet() {
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
		TeacherEnterHandle teacherEn = new TeacherEnterHandle();
	     request.setCharacterEncoding("UTF-8");
	     String subject = (String) request.getParameter("subject");
	     String teacher = (String) request.getParameter("teacher");
	     if(!teacherEn.isExist_teacher(teacher)){
	    	request.setAttribute("isRight", "teacherError");
	    	 RequestDispatcher rd= request.getRequestDispatcher("/Subject.jsp");
	         rd.forward(request, response);
	     }
	     else{
	    	 if(teacherEn.isExist_subject(subject)){
	    		 request.setAttribute("isRight", "subjectError");
		    	 RequestDispatcher rd= request.getRequestDispatcher("/Subject.jsp");
		         rd.forward(request, response);
	    	 }
	    	 else{
	    		int subjectid= teacherEn.InsertSubject(subject);
	    		teacherEn.InsertTeacher_subject(teacher, subjectid);
	    		request.setAttribute("isRight", "right");
	    		 RequestDispatcher rd= request.getRequestDispatcher("/Subject.jsp");
		         rd.forward(request, response);
	    	 }
	     }
	}

}
