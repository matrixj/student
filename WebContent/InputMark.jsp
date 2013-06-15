<%@page import="com.student.bean.model.Subject"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="HeadPage.jsp" %>
<script type="text/javascript">
	setTitleBar('title_mark');
</script>
<link type="text/css" href="css/input_mark.css" rel="stylesheet" />
<script type="text/javascript" src="js/input_mark.js"></script>
<%
	List<Subject> subjects = (List<Subject>) request.getAttribute("subjects");
	List<String> majors = (List<String>) request.getAttribute("majors");
	List<String> grades = (List<String>) request.getAttribute("grades");
	List<String> classes = (List<String>) request.getAttribute("classes");
%>
</head>
<body>
	<div class="row">
		<span class="float_left input_tips">录入科目：</span>
		<div class="float_left">
			<select size="1" class="input_select select_onchange" name="subject">
				<%
					if(subjects != null) {
						for(Subject sub : subjects) {
				%>		
							<option value="<%=sub.getSuid() %>"><%=sub.getName() %></option>
				<%		}
					}
				%>
			</select>
		</div>
		<div class="clear"></div>
	</div>
	
	<div class="row">
		<span class="float_left input_tips">录入成绩班级：</span>
		<div class="float_left">
			<select size="1" class="input_select select_onchange" name="major">
				<%
					if(majors != null) {
						for(String major : majors) {
				%>		
							<option><%=major %></option>
				<%		}
					}
				%>
			</select>
			<span>专业</span>
		</div>
		<div class="clear"></div>
	</div>
	
	<div class="row">
		<span class="float_left input_tips">&nbsp;</span>
		<div class="float_left">
			<select size="1" class="input_select select_onchange" name="grade">
				<%
					if(grades != null && grades.size() > 0) {
						for(String grade : grades) {
				%>		
							<option><%=grade %></option>
				<% 		
						}
					}
				%>
			</select>
			<span>年级</span>
			<select size="1" class="input_select" name="class">
				<%
					if(classes != null && classes.size() > 0) {
						for(String cls : classes) {
				%>		
							<option><%=cls %></option>
				<% 		
						}
					}
				%>
			</select>
			<span>班</span>
		</div>
		<div class="clear"></div>
	</div>
	
	<div class="row">
		<a href="javascript:;" class="a_btn" onclick="onInputClick();">选择录入</a>
	</div>
	
	<form action="" method="post" id="form_mark">
		<div class="row student_list" id="students"></div>
	</form>
</body>
</html>