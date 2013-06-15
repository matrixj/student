<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="HeadPage.jsp" %>
<%
	String result = request.getParameter("result");
%>
<style type="text/css">
	.tips {
		font-size: x-large;
		margin-top: 30px;
	}
	
	.mark_result {
		margin-top: 30px;
	}
	
</style>
</head>
<body>
	<%
		if(result.equals("success")) {
	%>	
			<div class="row">
				<img class="mark_result" alt="sucess" src="image/right.jpg">
				<div class="tips">添加成绩成功!</div>
				<a href="input_mark">沿路返回</a>
			</div>
	<%	
		}
		else {
	%>
			<div class="row">
				<img class="mark_result" alt="fail" src="image/wrong.jpg">
				<div class="tips">添加成绩失败！</div>
				<a href="input_mark">沿路返回</a>
			</div>	
	<%
		}
	%>
</body>
</html>