<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="HeadPage.jsp" %>
<link type="text/css" href="css/home.css" rel="stylesheet" />
</head>
<body>
	<div class="row welcome">
		<span class="welcome">欢迎使用成绩管理系统</span>
	</div>
	<div class="row home_tips">
		<span class="function">你可使用的功能：</span>
	</div>
	
	<%
		if(student != null) {
	%>
			<div class="row home_tips">
				<span class="function_list">1、查看自己的成绩</span>
			</div>
			<div class="row home_tips">
				<span class="function_list">2、统计自己的成绩</span>
			</div>
			<div class="row home_tips">
				<span class="function_list">3、查看个人信息</span>
			</div>
			<div class="row home_tips">
				<span class="function_list">4、修改个人信息</span>
			</div>
	<%
		}
		else {
	%>
			<div class="row home_tips">
				<span class="function_list">1、学生名单录入</span>
			</div>
			<div class="row home_tips">
				<span class="function_list">2、科目录入，录入后你是该科目的任课老师</span>
			</div>
			<div class="row home_tips">
				<span class="function_list">3、成绩录入，录入你所任课的科目学生成绩</span>
			</div>
			<div class="row home_tips">
				<span class="function_list">4、统计指定班级学生的成绩</span>
			</div>
	<%
		}
	%>
</body>
</html>