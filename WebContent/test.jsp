<%@page import="com.student.repository.StudentMessageControler"%>
<%@page import="com.student.bean.model.Teacher"%>
<%@page import="com.student.repository.TeacherMessageControler"%>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
<a href="showMarkServlet">showMark</a>
<a href="showInfoServlet">showInfo</a>
<a href="markAnalyse">markAnalyse</a>
<%
	//TeacherMessageControler tmc = new TeacherMessageControler();
	//Teacher[] t = tmc.SearchTeacher(null,"f",null);
	//out.print(t.length);
	StudentMessageControler smc = new StudentMessageControler();
	//smc.SearchStudent(null, null, null, null, null);
	out.print(smc.SearchStudent("001", null, null, null, null).length);
%>
</body>
</html>