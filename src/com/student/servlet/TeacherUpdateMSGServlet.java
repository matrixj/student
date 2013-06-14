package com.student.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.catalina.Session;

import com.student.repository.TeacherEnterHandle;

/**
 * Servlet implementation class TeacherUpdateMSGServlet
 */
@WebServlet("/TeacherUpdateMSGServlet")
public class TeacherUpdateMSGServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherUpdateMSGServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TeacherEnterHandle teacherEn = new TeacherEnterHandle();
		request.setCharacterEncoding("UTF-8");
		String grade_show =(String)request.getSession().getAttribute("Grade");
		String class_show =(String)request.getSession().getAttribute("Class");
		String major_show =(String)request.getSession().getAttribute("Major");
		String del = request.getParameter("del");
		teacherEn.DelStudent(del);
		RequestDispatcher rd= request.getRequestDispatcher("/TeacherEntering.jsp");
        request.setAttribute("isRight", "right");
        request.setAttribute("Grade", grade_show);
        request.setAttribute("Class",class_show);
        request.setAttribute("Major",major_show);
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TeacherEnterHandle teacherEn = new TeacherEnterHandle();
		request.setCharacterEncoding("UTF-8");
		String grade_show =(String)request.getSession().getAttribute("Grade");
		String class_show =(String)request.getSession().getAttribute("Class");
		String major_show =(String)request.getSession().getAttribute("Major");
		
		int Did =(Integer)request.getSession().getAttribute("Did");
		int i = 0,j=50;
		while(j!=0){
			String name = (String)request.getParameter("name"+i);
			String sex = (String)request.getParameter("sex"+i);
			String no = (String)request.getParameter("no"+i);
			String pw = (String)request.getParameter("pw"+i);
			if(no != null&& no !=""){
		if(teacherEn.isExist_student(no)){
			teacherEn.UpdateStudent(no, Did, sex, name, pw);
		}
		else{
			teacherEn.InsertStudent(no, Did, sex, name, pw);
		}
			}
			i++;
			j--;
			
		}
		 RequestDispatcher rd= request.getRequestDispatcher("/TeacherEntering.jsp");
         request.setAttribute("isRight", "right");
         request.setAttribute("Grade", grade_show);
         request.setAttribute("Class",class_show);
         request.setAttribute("Major",major_show);
         rd.forward(request, response);
	}

}
