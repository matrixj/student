<%@page import="javax.swing.JOptionPane"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html >
<head>
<%@include file="HeadPage.jsp" %>
<script type="text/javascript">
	setTitleBar('title_subject');
</script>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>科目录入</title>
  <link href="css/styles.css" rel="stylesheet" />
</head>
<body>
     <% 
     String teacherName =  name;
     String isRight = (String) request.getAttribute("isRight");
     if(isRight == "teacherError"){
    	 %>
  	   <script language="javascript">
  	   alert("教师不存在！");
  	   </script>
    <%
     }%>
     <% 
      if(isRight == "subjectError"){
    	 %>
  	   <script language="javascript">
  	   alert("科目已存在！");
  	   </script>
    <%
     }%>
      <% 
      if(isRight == "right"){
    	 %>
  	   <script language="javascript">
  	   alert("科目创建成功！");
  	   </script>
    <%
     }%>
     
  <div id="carbonForm">
    <h1>科目录入</h1>
    <form action="SubjectEnter" method="post" id="signupForm">
    <div class="fieldContainer">
      <div class="formRow">
        <div class="label">
          <label >Teacher:</label>
        </div>
        <div class="field">
          <input type="text" name="teacher" id="teacher" value="<%=teacherName%>"/>
        </div>
      </div>
      <div class="formRow">
        <div class="label">
          <label >Subject:</label>
        </div>
        <div class="field">
          <input type="text" name="subject" id="subject" />
        </div>
      </div>
      
    </div>
    <div class="signupButton">
      <input type="submit" name="submit" id="submit" value="录入" />
    </div>
    </form>
  </div>
</body>
</html>