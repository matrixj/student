<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="HeadPage.jsp" %>
<link href="css/styles.css" rel="stylesheet" />
<title>新建班级</title>
</head>
<body>

<% 
      if(request.getAttribute("success")=="NO"){
    	  
    	  %>
	   <script language="javascript">
	   alert("班级已存在，请重试！");
	   </script>
 <% }
%>
<div id="carbonForm">
    <h1>班级创建</h1>
    <form action="CreateClassSevlet" method="post" id="signupForm">
    <div class="fieldContainer">
      <div class="formRow">
        <div class="label">
          <label >Grade:</label>
        </div>
        <div class="field">
          <input type="text" name="grade" id="grade" />
        </div>
      </div>
      <div class="formRow">
        <div class="label">
          <label >Class:</label>
        </div>
       
        <div class="field">
          <input type="text" name="_class" id="_class" />
        </div>
      </div>
      <div class="formRow">
        <div class="label">
          <label>Major:</label>
        </div>
       
        <div class="field">
          <input type="text" name="major" id="subject" />
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