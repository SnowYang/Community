<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="db.DB" %>
<%@ page import="model.Message" %>
<%@ page import="java.util.ArrayList"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <body>

  <center>
  当前用户是${user.username } <a href="servlet/exit">退出登录</a>
  <form action="addMessage.jsp" method="post">
  <table width="80%" cellspacing="0" cellpadding="0" border="1">

 <caption>全部留言信息</caption>
<tr>
<th>留言人姓名</th>
<th>留言标题</th>
<th>留言时间</th>
<th>留言内容</th>
</tr>
<%
ArrayList list=(ArrayList)request.getAttribute("messageList");
Iterator iter=list.iterator();
while(iter.hasNext())
{
	Message message=(Message)iter.next();
	

 %>
 <tr>
  <td><%%></td>
  <td><%=message.getTitle()%></td>
  <td><%=message.getDate() %></td>
  <td><%=message.getContent() %></td>
 </tr>
 <%} %>
</table> 
<br/>
<input type="submit" value="留言">
</form>
  </center>  
  </body>
</html>
