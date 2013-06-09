<%@page import="javax.swing.JOptionPane"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师录入班级/学生信息</title>
<style type="text/css">
#td{
   border-style: groove;
}
</style>
</head>
<body>
<%   String isRight =  (String)request.getAttribute("isRight");
       if(isRight == "error"){
      %>
    	   <script language="javascript">
    	   alert("班级不存在！");
    	   </script>
      <% }
      %>
      <% 
      if(request.getAttribute("success")=="Yes"){
    	  
    	  %>
	   <script language="javascript">
	   alert("班级建立成功！");
	   </script>
 <% }
%>
<jsp:useBean id="teacher" class="com.student.bean.TeacherEnterBean" scope="page"></jsp:useBean>
         <form action="TeacherEnterSevlet" method="post" >
         <center>教师：<select name="teacher">
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
         <input type="submit" value="确定" > &nbsp&nbsp <a href="CreateClass.jsp"  >创建班级</a></center>
         </form>
         <%  
       if(isRight == "right"){
    	  String grade_show = (String)request.getAttribute("Grade");
    	  String class_show = (String)request.getAttribute("Class");
    	  String major_show = (String)request.getAttribute("Major");
          %>
          <br>
          <form action="TeacherUpdateMSGServlet" method="post">
          <center>
         <table style="border-style: solid;" id="test">
         <tr><td>姓名</td><td>性别</td><td>学号</td><td>密码</td></tr>
         <%
            i = 0;
         String[][] msg = teacher.Student(grade_show, class_show,major_show);
         int Did = teacher.Did(grade_show, class_show,major_show);
       
               while(msg[i][1]!=null){
            	   %>
            <tr id="<%=i%>">
            <td><input type="text" value="<%=msg[i][1]%>" name="name"+<%=i%>></td>
            <td><input type="text" value="<%=msg[i][2]%>"  name="sex"+<%=i%>></td>
            <td><input type="text" value="<%=msg[i][0]%>"  name="no"+<%=i%>></td>
            <td><input type="text" value="<%=msg[i][3]%>"  name="pw"+<%=i%>></td></tr>	   
            	   <%
            	   i++;
               }
               session.setAttribute("Grade", grade_show);
               session.setAttribute("Class",class_show);
               session.setAttribute("Major",major_show);

               session.setAttribute("Did", Did);
               request.setAttribute("tableNum", i-1);
         %>
       
         </table>
       <input type="submit" value="提交"><input type="button" value="增加一行" onclick="javascript:insert_row()" />
         </center>
         </form>
         
      <% }
      %>
         <script type="text/javascript">
         var optionsNum = 1;	
         var i = "${requestScope.tableNum}";				//插入行		
         function insert_row(){			
        	 var itemTable = document.getElementById("test");	
        	 i = itemTable.rows.length ;
        	 i++;		
        	 R = itemTable.insertRow()	;	
        	 R.id =  i;						//序号	
        	 C=R.insertCell()	;		
        	 C.align = "center";		
        		
        	 C.innerHTML="<input class=\"text\" type=\"text\"  name=\"pw"+i+"\"   />";	
        	 C=R.insertCell()	;		
        	 C.align = "center";		
        	
        	 C.innerHTML="<input class=\"text\" type=\"text\" name=\"no"+i+"\"   />";	
        	 C=R.insertCell()	;		
        	 C.align = "center";		
        		
        	 C.innerHTML="<input class=\"text\" type=\"text\"  name=\"sex"+i+"\" />";	
        	 C=R.insertCell()	;		
        	 C.align = "center";		
        	
        	 C.innerHTML="<input class=\"text\" type=\"text\"  name=\"name"+i+"\" />";
         }
         </script>
        
</body>
</html>