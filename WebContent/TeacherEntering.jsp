<%@page import="javax.swing.JOptionPane"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="HeadPage.jsp" %>
<title>教师录入班级/学生信息</title>
 <link href="css/TeacherStyle.css" rel="stylesheet" />
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
        <input type="submit" value="确定" > &nbsp&nbsp <a href="TeacherEnterSevlet"  >创建班级</a></center>
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
         <table  id="test">
         <thead>
<th>姓名</th><th>性别</th><th>学号</th><th>密码</th><th>操作</th></tr></thead>
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
            <td><input type="text" value="<%=msg[i][3]%>"  name="pw"+<%=i%>></td>
            <td><a href="TeacherUpdateMSGServlet?del=<%=msg[i][0]%>">删除</a></td></tr>	   
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
         <div class="signupButton">
      <input type="submit" value="提交" id="submit"><input id="add" type="button" value="增加一行" onclick="javascript:addtr()" />
    </div>
       
         </center>
         </form>
         
      <% }
      %>
         <script language="javascript" type="text/javascript">    
         var i = "${requestScope.tableNum}"; 
     function addtr(){ //增加表格    
        var tem = ++i;    
        var t = document.getElementById("test");    
        var row = t.insertRow(t.rows.length);     
        row.id=tem;    
        var cell1 = row.insertCell(0);        
        var cell2 = row.insertCell(1);      
        var cell3 = row.insertCell(2);      
        var cell4 = row.insertCell(3);    
        cell4.innerHTML="<input class=\"text\" type=\"text\"  name=\"pw"+i+"\"   />";    
        cell3.innerHTML="<input class=\"text\" type=\"text\" name=\"no"+i+"\"   />";	
        cell2.innerHTML="<input class=\"text\" type=\"text\"  name=\"sex"+i+"\" />";    
        cell1.innerHTML="<input class=\"text\" type=\"text\"  name=\"name"+i+"\" />";
        document.f.hid.value=id;    
    }    
        
    function deltr(){  //删除表格    
        var tdel = document.getElementById("tab");    
        tdel.deleteRow(id+2);    
        id--;    
        document.f.hid.value=id;    
    }    
</script>   
         
        
</body>
</html>