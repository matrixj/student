<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="css/head.css" rel="stylesheet" />
<link type="text/css" href="css/common.css" rel="stylesheet" />
<script type="text/javascript" src="js/head.js"></script>
<title>成绩管理系统</title>
</head>
<div id="div_headPage">
	<div class="headTips">
		<div class="hello">
			<span>身份：学生</span>
			<div class="float_right">
				<span>你好，</span>
				<a href="">屌丝</a>
				<a href="" class="float_right" onmouseover="onLogoutHover(this);" onmouseout="onLogoutLeave(this);">退出登录</a>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	
	<div id="div_title_bar">
		<ul class="ul_title">
			<li class="li_title"><a class="a_title" href="home">首页</a></li>
			<li class="li_title"><a class="a_title" href="">成绩查询</a></li>
			<li class="li_title"><a class="a_title" href="">成绩统计</a></li>
			<li class="li_title"><a class="a_title" href="">个人资料</a></li>
		</ul>
	</div>
	
	<script type="text/javascript">
		setHeadBarMouse();
		addBackground();
	</script>
	
</div>

</html>