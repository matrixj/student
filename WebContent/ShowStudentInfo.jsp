<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="GB18030"%>
<%@ page import="com.student.bean.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="HeadPage.jsp" %>
<script type="text/javascript">
	setTitleBar('title_info');
</script>
<title>个人信息</title>
<style type="text/css">
.info{
	position: relative;
	left: 50%;
	margin: 0 -350px 0 -350px;
	
	background-color: #0099ff;
	width: 700px;
	height: 500px;
	border: 2px solid #000099;
}
.info table{
	font-size: 30px;
}
.info a{
	position:relative;
	left:70%;
	top:-10px;
	text-decoration: none;
	background-color: #0033cc;
	padding: 10px;
	font-size: 20px;
	color: #ffffff;
}
.info a:HOVER{
	-webkit-animation: mouseover 0.3s;
	font-size: 25px;
}
@-webkit-keyframes mouseover{
	from{
		font-size: 20px;	
	}
	to{
		font-size: 25px;
		width: 80px;
	}
}
</style>
</head>
<body bgcolor="#b2dfee">
	<div class="info">
	<% Student stu = (Student)session.getAttribute("Student"); %>
		<table cellpadding="40px">
			<tr><td>学号:</td><td><%=stu.getNo() %></td></tr>
			<tr><td>姓名:</td><td><%=stu.getName() %></td></tr>			
			<tr><td>班级:</td><td><%=stu.getDepartment().getCls() %></td></tr>
			<tr><td>性别:</td><td><%=stu.getSex() %></td></tr>
		</table>
		<a href="modifyPwdPage">修改密码</a>
	</div>
</body>
</html>