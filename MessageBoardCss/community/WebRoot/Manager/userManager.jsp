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
    
    <title>My JSP 'userManager.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="style/my.css" rel="stylesheet" type="text/css" />
  
<style type="text/css">
#customers
  {
  font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
  width:80%;
  border-collapse:collapse;
  margin-top:100px;
  }

#customers td, #customers th 
  {
  font-size:13px;
  border:1px solid #669999;
  padding:3px 7px 2px 7px;
  line-height:25px;
  }

#customers th 
  {
  font-size:14px;
  text-align:center;
  padding-top:4px;
  padding-bottom:4px;
  background-color:#336666;
  color:#ffffff;
  }

#customers tr.alt td 
  {
  color:#336666;
  background-color:#EAF2D3;
  }
</style> 
  </head>
  
  <body>
  <%
 User user=(User)request.getSession().getAttribute("user");
 if(user==null)
 { 
   response.sendRedirect("/MessageBoardCss/Manager/loginManager.jsp");
 }
 %>
 
 <center>
<table id="customers">

<tr>
<th>用户名</th>
<th>性别</th>
<th>用户地址</th>
<th>用户身份</th>
<th colspan="4" style="text-align:center; color:red;">管理用户信息</th>


</tr>
  <%
ArrayList list=(ArrayList)request.getAttribute("userList");
Iterator iter=list.iterator();
while(iter.hasNext())
{
	User userAll=(User)iter.next();
	String str="";
	if(userAll.getUserstatus().equals("1"))
	{
	 str="管理员";
	}
	else
	{
	 str="普通会员";
	}
	
 %>
<tr>
<td><%=userAll.getUsername()%></td>
<td><%=userAll.getUsersex() %></td>
<td><%=userAll.getUseradr() %></td>
<td><%=str%></td>
<td><a href="/MessageBoardCss/Manager/updateUser.jsp?id=<%=userAll.getId() %>">修改</a></td>
<td><a href="/MessageBoardCss/servlet/deleteUser?id=<%=userAll.getId() %>">删除</a></td>
<td><a href="/MessageBoardCss/servlet/setUserPwd?id=<%=userAll.getId() %>">重置用户密码</a></td>
<td><a href="/MessageBoardCss/servlet/setAdmin?id=<%=userAll.getId() %>">设置为管理员</a></td>
</tr>
<%} %>
</table> 
</center>
  </body>
</html>
