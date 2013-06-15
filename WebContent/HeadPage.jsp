<%@page import="com.student.bean.model.Person"%>
<%@page import="com.student.bean.model.Student"%>
<%@page import="com.student.bean.model.Teacher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="css/head.css" rel="stylesheet" />
<link type="text/css" href="css/common.css" rel="stylesheet" />
<script type="text/javascript" src="js/head.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<title>成绩管理系统</title>
<%
	Teacher teacher = (Teacher) session.getAttribute("Teacher");
	Student student = (Student) session.getAttribute("Student");
	String name = null;
	String identify = null;
	if(teacher != null) {
		identify = "老师";
		name = teacher.getName();
	}
	else {
		identify = "学生";
		name = student.getName();
	}
%>
</head>
<div id="div_headPage">
	<div class="headTips">
		<div class="hello">
			<span>身份：<%=identify %></span>
			<div class="float_right">
				<span>你好，</span>
				<% 
					if(teacher != null) {
				%> 
						<a><%=name %></a>
				<%
					} 
					else {
				%>
						<a href="showInfo"><%=name %></a>
				<%
					}
				%>
				<a href="" class="float_right" onmouseover="onLogoutHover(this);" onmouseout="onLogoutLeave(this);">退出登录</a>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	
	<div id="div_title_bar">
		<ul class="ul_title">
			<%
				if(teacher != null) {
			%>
					<li class="li_title teacher_title"><a id="title_home" class="a_title" href="home">首页</a></li>
					<li class="li_title teacher_title"><a id="title_analyse" class="a_title" href="markAnalyse">成绩统计</a></li>
					<li class="li_title teacher_title"><a id="title_subject" class="a_title" href="SubjectEnter">科目录入</a></li>
					<li class="li_title teacher_title"><a id="title_student" class="a_title" href="TeacherUpdateMSGServlet">名单录入</a></li>
					<li class="li_title teacher_title"><a id="title_mark" class="a_title" href="input_mark">成绩录入</a></li>
			<%
				}
				else {
			%>
					<li class="li_title student_title"><a id="title_home" class="a_title" href="home">首页</a></li>
					<li class="li_title student_title"><a id="title_mark" class="a_title" href="showMarkServlet">成绩查询</a></li>
					<li class="li_title student_title"><a id="title_info" class="a_title" href="showInfo">个人资料</a></li>
			<%
				}
			%>
		</ul>
	</div>
	
	<script type="text/javascript">
		setHeadBarMouse();
	</script>
	
</div>

</html>