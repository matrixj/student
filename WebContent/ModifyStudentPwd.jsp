<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>�޸���Ϣ</title>
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
	<form action="" method="post">
		<div class="info">
			<table cellpadding="40px">
				<tr><td>Դ���� :</td><td><input type="password" name="oldPassword"></td></tr>
				<tr><td>������ :</td><td><input type="password" name="newPassword"></td></tr>
				<tr><td>ȷ������ :</td><td><input type="password" name="confirmPassword"></td></tr>
				<tr><td colspan="2" align="right"><input type="submit" value="�ύ" class="submit"></td></tr>
			</table>
		</div>
	</form>
</body>
</html>