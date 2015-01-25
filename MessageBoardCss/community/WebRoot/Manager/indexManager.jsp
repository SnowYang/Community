<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'indexManager.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="style/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="style/js.js"></script>

  </head>

<body id="index">
<%
 User user=(User)request.getSession().getAttribute("user");
 if(user==null)
 { 
   response.sendRedirect("/MessageBoardCss/Manager/loginManager.jsp");
 }
 %>
<h1>系统管理界面</h1>
<div id="userInfo">你好，管理员!</div>
<ul id="globalNav">
	<h2>管理菜单</h2>
	<li><a href="/MessageBoardCss/servlet/userDisplyManager" target="frameBord">用户管理</a></li>
	<li><a href="#" target="frameBord">留言管理</a></li>
	<li><a href="#" target="frameBord">回复管理</a></li>
	<li><a href="#" target="frameBord">站点介绍</a></li>
	<li><a href="/MessageBoardCss/Manager/loginManager.jsp" target="frameBord">用户登录</a></li>
	<li><a href="/MessageBoardCss/servlet/outLoginAdmin" target="frameBord">退出登录</a></li>
</ul>
<iframe id="frameBord" name="frameBord" frameborder="0" width="100%" height="100%" src="/MessageBoardCss/Manager/siteInfo.html"></iframe>
</body>

</html>
