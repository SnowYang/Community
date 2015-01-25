<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link href="style/style.css" rel="stylesheet" type="text/css" />
    <title>My JSP 'loginManager.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body id="login">
  
   <form action="/MessageBoardCss/servlet/loginManager" id="loginForm" method="post">
	<h3>后台管理系统</h3>
	<label for="userName"><span>用户名：</span><input id="userName" name="username" type="text" /></label>
	<label for="passWord"><span>密码：</span><input id="passWord" type="password" name="userpwd"/></label>
	<label id="submit"><input name="" type="submit" class="bt" value="确定" />
	<input type="button" class="bt" value="注册"/>
	</label>
</form>
<p id="siteCopyRight">版权所有：www.richbox.net</p>
  </body>
</html>
