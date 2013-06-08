<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>欢迎</title>
<style type="text/css">
.top{
	position:absolute;
	top:0;
	left:0;
	width: 100%;
	height: 30%;
	background: #b2dfee;
	border-bottom: 5px solid #8b8989;
	z-index: 1;
}

.teacher,.student{
	background-color: #0066ff;
	position:relative;
	top:200px;
	left:35%;
	color: #b2dfee;
	font-size: 30px;
	width: 60px;
	text-decoration: none;
	margin: 20px;
	padding: 10px;
	border: 3px solid #8b8989;
	border-radius:15px;
}
.teacher:HOVER, .student:HOVER {
	-webkit-animation: mouseover 0.5s;
	background-color:#b2dfee;
	color: #0066ff;
}

@-webkit-keyframes load{
	from{
		left: 0;		
	}
	to{
		left: 35%;
	}
}
@-webkit-keyframes mouseover{
	from{
		background-color:#0066ff;
		color: #b2dfee
	}
	to{
		background-color:#b2dfee;
		color: #0066ff;
	}
}
@-webkit-keyframes loginform{
	from{
		top: 400px;
	}
	to{
		top: 100px;
	}
}
.form{
	background-color: #b2dfee;
	position: relative;
	left: 38%;
	top: 100px;
	border: 2px solid #8b8989;
	width: 300px;
	-webkit-animation: loginform 0.5s;
	font-size: 20px;
	color: #0066ff;
	z-index: 2;
	border-radius:20px;
	font-weight:bold;
}
.btn{
	width: 50px;
	border: 2px solid #000099;
	margin: 5px;
}
h1{
	position: relative;
	top:80px;
	z-index: 2
}
</style>
</head>
<body bgcolor="#0066ff" style="overflow-y:hidden">
	<h1 align="center" style="color:#0066ff;font-size: 50px">学生成绩管理系统</h1>
	<%
		if(request.getParameter("flag")==null){
	%>
		<a class="teacher" href="LoginPage.jsp?flag=1">老师入口</a>
		<a class="student" href="LoginPage.jsp?flag=0">学生入口</a>
	<% 
		}
		else{
	%>
		<div class="form">
			<form action="loginServlet?flag=<%= request.getParameter("flag") %>" method="post">
				<table cellspacing="10px" width="300px">
					<tr><td colspan="2"><h4><% if(request.getParameter("flag").equals("1")){out.print("老师登陆");}else {out.print("学生登陆");} %></h4></td></tr>
					<tr><td>用户名:</td><td><input type="text" name="ID"/></td></tr>
					<tr><td>密码:</td><td><input type="password" name="password"/></td></tr>
					<tr><td colspan="2" align="right"><input type="submit" value="登陆" class="btn"><input type="reset" value="重置" class="btn"></td></tr>
				</table>
			</form>
		</div>
	<%
		}
	%>
	<div class="top"></div>
</body>
</html>






