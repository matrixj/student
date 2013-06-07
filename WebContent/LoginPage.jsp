<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>欢迎</title>
<style type="text/css">
.teacher,.student{
	color: #000099;
	display: inline;
	font-size: 30px;
	width: 60px;
	text-decoration: none;
}
.teacher:HOVER, .student:HOVER {
	-webkit-animation: mouseover 1s;
	font-size: 50px;
}

@-webkit-keyframes mouseover{
	from{
		font-size: 30px;
		width: 60px;		
	}
	to{
		font-size: 50px;
		width: 100px;
	}
}
@-webkit-keyframes loginform{
	from{
		left: 0;
	}
	to{
		left: 100px;
	}
}
.form{
	background-color: #b2dfee;
	position: relative;
	left: 100px;
	border: 2px solid #000099;
	width: 300px;
	-webkit-animation: loginform 1s;
	font-size: 20px;
}
.btn{
	width: 50px;
	border: 2px solid #000099;
	margin: 5px;
}
</style>
</head>
<body bgcolor="#b2dfee">
	<%
		if(request.getParameter("flag")==null){
	%>
		<a class="teacher" href="LoginPage.jsp?flag=1">老师</a>
		<a class="student" href="LoginPage.jsp?flag=0">学生</a>
	<% 
		}
		else{
	%>
		<form action="" method="post">
			<div class="form">
				<table cellspacing="10px" width="300px">
					<tr><td colspan="2"><% if(request.getParameter("flag").equals("1")){out.print("老师登陆");}else {out.print("学生登陆");} %></td></tr>
					<tr><td>用户名:</td><td><input type="text" name="ID"/></td></tr>
					<tr><td>密码:</td><td><input type="text" name="password"/></td></tr>
					<tr><td colspan="2" align="right"><input type="submit" value="登陆" class="btn"><input type="reset" value="重置" class="btn"></td></tr>
				</table>
			</div>
		</form>
	<%
		}
	%>
</body>
</html>






