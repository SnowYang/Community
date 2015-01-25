<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="db.DB" %>
<%@ page import="model.Message" %>
<%@ page import="model.User" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Reply.jsp' starting page</title>
    
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
  <%
  String id=request.getParameter("id");
  User user=(User)request.getSession().getAttribute("user");
  String username="";
  if(user==null)
  {
   response.sendRedirect("/MessageBoard/Login.jsp");
  }
  else
  {
  	username=user.getUsername();
  }
   %>
    <form action="servlet/replyMessage" method="post">
    <table border="1" width="70%">
    <caption>填写回复留言信息</caption>
    <tr>
    <td>回复内容</td>
    <td>
    <textarea name="replycontent" rows="5" cols=""35></textarea>
    <input type="hidden" value="<%=id %>" name="replyid">
    <input type="hidden" value="<%=username%>" name="replyusername">
    </td>
    </tr>
    </table>
    <input type="submit" value="提交">
     <input type="reset" value="重置">
    </form>
   </center>
  </body>
</html>
