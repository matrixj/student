<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建班级</title>
</head>
<body>
        <style type="text/css">
<!--
body,td,th {
font-family: 宋体;
font-size: 14px;
}
.STYLE1 {
font-size: 24px;
font-weight: bold;
}
-->
</style>
<p align="center" class="STYLE1">班级信息</p>
<% 
      if(request.getAttribute("success")=="NO"){
    	  
    	  %>
	   <script language="javascript">
	   alert("班级已存在，请重试！");
	   </script>
 <% }
%>
<form action="CreateClassSevlet" method="post" >
<table width="400" border="3" align="center" cellpadding="0" cellspacing="0" bordercolor="#000000" bgcolor="#99CCFF">
<tr>
<td width="96" height="30" align="center">建班者</td>
<td width="96" height="30" align="center"><input type="text" name="teacher" ></td>
<td width="97" height="30" align="center">班级代号(11位内)</td>
<td width="97" height="30" align="center"><input type="text" name="Did"></td>
</tr>
<tr>
<td height="30" align="center">年级</td>
<td height="30" align="center"><input type="text" name="grade"></td>
<td height="30" align="center">班级</td>
<td height="30" align="center"><input type="text" name="_class"></td>
</tr>
<tr>
<td height="30" align="center">人数</td>
<td height="30" align="center"><input type="text" name="count"></td>
<td height="30" align="center">专业</td>
<td height="30" align="center"><input type="text" name="major"></td>
</tr>
<tr>
<td height="30" colspan="2" align="center">&nbsp;</td>
<td height="30" colspan="2" align="center">&nbsp;</td>
</tr>
<tr>
<td height="30" colspan="2" align="center">&nbsp;</td>
<td height="30" colspan="2" align="center">&nbsp;</td>
</tr>
<tr>
<td height="30" colspan="2" align="center">&nbsp;</td>
<td height="30" colspan="2" align="center"><input type="reset" name="重置" style="border-right-width: thick;"><input type="submit" name="提交" style="border-right-width: thick;"></td>
</tr>
</table>
</form>
</body>
</html>