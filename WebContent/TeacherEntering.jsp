<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师录入班级/学生信息</title>
</head>
<body>
<jsp:useBean id="teacher" class="com.student.bean.TeacherEnterBean" scope="page"></jsp:useBean>
         <form action="TeacherEnterSevlet" method="post" >
         <p>教师：<select name="teacher">
         <% String[] name = teacher.AllTeacherName();
         int i = 0 ;
             while (name[i]!=null){%>
            	 <option name="<%=name[i]%>"><%=name[i] %></option>
             <%
             i++;}
         %>
         </select>
         &nbsp&nbsp&nbsp&nbsp 
                                 专业：<select name="Major">
         <% String[] major = teacher.Major();
             i = 0 ;
             while (major[i]!=null){%>
            	 <option name="<%=major[i]%>"><%=major[i] %></option>
           <%
             i++;}
         %></select>
                                     年级：<select name="Grade">
           <% String[] grade = teacher.Grade();
             i = 0 ;
             while (grade[i]!=null){%>
            	 <option name="<%=grade[i]%>"><%=grade[i] %></option>
           <%
             i++;}%>
            </select> 班级: <select name="Class">
                                        <% String[] Class= teacher.Class();
             i = 0 ;
             while (Class[i]!=null){%>
            	 <option name="<%=Class[i]%>"><%=Class[i] %></option>
           <%
             i++;}
             %>
             </select>
         &nbsp&nbsp&nbsp&nbsp
         <input type="submit" value="确定" > &nbsp&nbsp <a href="#">创建班级</a></p>
         </form>
</body>
</html>