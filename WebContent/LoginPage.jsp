<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>��ӭ</title>
<style type="text/css">
.teacher,.student{
	background-color:#000099;
	position:relative;
	left:39%;
	color: #ffffff;
	display: inline;
	font-size: 30px;
	width: 60px;
	text-decoration: none;
	margin: 0;
	padding: 10px;
}
.teacher:HOVER, .student:HOVER {
	-webkit-animation: mouseover 1s;
	font-size: 40px;
}

@-webkit-keyframes mouseover{
	from{
		font-size: 30px;
		width: 60px;		
	}
	to{
		font-size: 40px;
		width: 80px;
	}
}
@-webkit-keyframes loginform{
	from{
		left: 0;
	}
	to{
		left: 38%;
	}
}
.form{
	background-color: #b2dfee;
	position: relative;
	left: 38%;
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
	<h1 align="center" style="color:#000099;font-size: 50px">ѧ���ɼ�����ϵͳ</h1>
	<%
		if(request.getParameter("flag")==null){
	%>
		<a class="teacher" href="LoginPage.jsp?flag=1">��ʦ���</a>
		<a class="student" href="LoginPage.jsp?flag=0">ѧ�����</a>
	<% 
		}
		else{
	%>
		<form action="loginServlet?flag=<%= request.getParameter("flag") %>" method="post">
			<div class="form">
				<table cellspacing="10px" width="300px">
					<tr><td colspan="2"><% if(request.getParameter("flag").equals("1")){out.print("��ʦ��½");}else {out.print("ѧ����½");} %></td></tr>
					<tr><td>�û���:</td><td><input type="text" name="ID"/></td></tr>
					<tr><td>����:</td><td><input type="text" name="password"/></td></tr>
					<tr><td colspan="2" align="right"><input type="submit" value="��½" class="btn"><input type="reset" value="����" class="btn"></td></tr>
				</table>
			</div>
		</form>
	<%
		}
	%>
</body>
</html>






