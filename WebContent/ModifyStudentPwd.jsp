<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>修改信息</title>
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
.info .submit{
	width: 100px;
	border: 2px solid #000099;
	margin: 5px;
}
</style>
</head>
<body bgcolor="#b2dfee">
	<form action="modifyPwd" method="post" class="info">
		<div>
			<table cellpadding="40px">
				<tr><td>源密码 :</td><td><input type="password" name="oldPassword"></td></tr>
				<tr><td>新密码 :</td><td><input type="password" name="newPassword"></td></tr>
				<tr><td>确认密码 :</td><td><input type="password" name="confirmPassword"></td></tr>
				<tr><td colspan="2" align="right"><input type="submit" value="提交" class="submit"></td></tr>
			</table>
		</div>
		<span>&nbsp&nbsp&nbsp&nbsp</span>
	<%
		if(request.getParameter("flag")==null);
		else if(request.getParameter("flag").equals("1")){
			out.print("<span style=\"font-size:25px;color:#ff0000\">源密码错误</span>");
		}
		else if(request.getParameter("flag").equals("2")){
			out.print("<span style=\"font-size:25px;color:#ff0000\">两次输入的密码不相同</span>");
		}
		else if(request.getParameter("flag").equals("3")){
			out.print("<span style=\"font-size:25px;color:#ff0000\">修改成功</span>");
		}
	%>
	<br>
	</form>
</body>
</html>




