<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030" import="com.student.bean.model.Mark"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>���˳ɼ�</title>
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
</style>
</head>
<body bgcolor="#b2dfee">
	<%
		Mark[] marks = (Mark[])request.getAttribute("marks");
		if(marks==null)out.print("�޳ɼ���¼");
		else{
	%>
	<div class="info">
		<table>
			<tr><th>��Ŀ</th><th>�ɼ�</th><th>�ο���ʦ</th></tr>
			<%
				for(int i=0;i<marks.length;++i){
			%>
				<tr><td><%=marks[i].getSubject().getName() %></td><td><%=marks[i].getScore() %></td><td><%=marks[i].getTeacher().getName() %></td></tr>
			<%
				}
			}
			%>
		</table>
	</div>
</body>
</html>