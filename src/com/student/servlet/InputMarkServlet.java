package com.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.bean.model.Subject;
import com.student.repository.DepartmentMessageControler;
import com.student.repository.TeacherMessageControler;
import com.student.util.JsonUtil;

/**
 * 录入成绩
 * @author 李亮灿
 *
 */
public class InputMarkServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String subject = req.getParameter("subject");
		String major = req.getParameter("major");
		String grade = req.getParameter("grade");
		String cls = req.getParameter("class");
		if(subject != null && major != null && grade != null && cls != null) {
		}
		else {
			if(subject != null && major != null && 
					!subject.equals("") && !major.equals("")) {
				if(grade != null && !grade.equals("")) {
					getClassPage(req, resp, subject, major, grade, "1");
				}
				else {
					getGradeClassPage(req, resp, subject, major, "1");
				}
			}
			else {
				getRowPage(req, resp, "1");
			}
		}
	}
	
	/**
	 * 获取原始页面
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void getRowPage(
			HttpServletRequest req, HttpServletResponse resp, String tid) 
			throws ServletException, IOException {
		TeacherMessageControler tmc = new TeacherMessageControler();
		DepartmentMessageControler dmc = new DepartmentMessageControler();
		List<Subject> subjects = tmc.getTeacherSubject(tid);
		List<String> majors = dmc.getAllMajors();
		List<String> grades = null;
		List<String> classes = null;
		if(subjects != null && subjects.size() > 0 && 
				majors != null && subjects.size() > 0) {
			grades = dmc.getAllowInputMarkGrade(
					subjects.get(0).getSuid() + "", majors.get(0), tid);
		}
		if(grades != null && grades.size() > 0) {
			classes = dmc.getAllowInputMarkClass(
					subjects.get(0).getSuid() + "", 
					majors.get(0), tid, 
					grades.get(0));
		}
		tmc.Close();
		dmc.close();
		req.setAttribute("subjects", subjects);
		req.setAttribute("majors", majors);
		req.setAttribute("grades", grades);
		req.setAttribute("classes", classes);
		req.getRequestDispatcher("InputMark.jsp").forward(req, resp);
	}
	
	private void getGradeClassPage(
			HttpServletRequest req, HttpServletResponse resp, 
			String subject, String major, String tid) throws IOException {
		PrintWriter out = resp.getWriter();
		DepartmentMessageControler dmc = new DepartmentMessageControler();
		List<String> grades = dmc.getAllowInputMarkGrade(subject, major, tid);
		List<String> classes = null;
		if(grades != null && grades.size() > 0) {
			classes = dmc.getAllowInputMarkClass(
					subject, major, tid, grades.get(0));
		}
		dmc.close();
		JsonUtil.sendJson(out, "grades", grades, "classes", classes);
		out.flush();
		out.close();
	}

	private void getClassPage(
			HttpServletRequest req, HttpServletResponse resp, 
			String subject, String major, String grade, String tid) 
					throws IOException {
		PrintWriter out = resp.getWriter();
		DepartmentMessageControler dmc = new DepartmentMessageControler();
		List<String> classes = dmc.getAllowInputMarkClass(
				subject, major, tid, grade);
		dmc.close();
		JsonUtil.sendJson(out, "classes", classes);
	}
	
}
