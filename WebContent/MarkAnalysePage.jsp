<%@page import="com.student.bean.model.Mark"%>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>�ɼ�����</title>
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
.info .submit{
	text-decoration: none;
	background-color: #0033cc;
	padding: 5px;
	font-size: 15px;
	color: #ffffff;
}
table td,th{
	border: 1px solid #000000;
	width: 100px;
	height: 30px;
}
</style>
</head>
<body bgcolor="#b2dfee">
<div class="info">
<div>
	<form action="markAnalyse" method="post">
		�༶��<input type="text" name="department"/>��Ŀ��<input type="text" name="subject"/>
		<input type="submit" value="��ѯ�ɼ�" class="submit"> 
	</form>
</div>
<%
	Mark[] marks = (Mark[])request.getAttribute("marks");
	if(marks!=null){
		double max = 0;
		double sum = 0;
		for(int i=0;i<marks.length;++i){
			if(marks[i].getScore()>max)max=marks[i].getScore();
			sum+=marks[i].getScore();
		}
		sum/=marks.length;
%>
<div>
	<table>
		<tr><th>����</th><th>�༶</th><th>��Ŀ</th><th>�ɼ�</th><th>�ο���ʦ</th></tr>
		<%
		for(int i=0;i<marks.length;++i){
		%>
			<tr><td><%=marks[i].getStudent().getName() %></td><td><%=marks[i].getStudent().getDepartment().getCls() %></td><td><%=marks[i].getSubject().getName() %></td><td><%=marks[i].getScore() %></td><td><%=marks[i].getTeacher().getName() %></td></tr>

<%
		}
		%>
	</table>
	<%if(request.getAttribute("flag")!=null){%>
		<span>��߷֣�<%=max %></span><span>ƽ���֣�<%=sum %></span>
	<%}%>
</div>
		<%
	}
%>
</div>
</body>
</html>