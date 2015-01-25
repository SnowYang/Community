<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%@ page import="db.DB" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateUser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  	<script type="text/javascript">
	function showlogo()
	{
		var image=document.getElementById("image1");
		image.src="image/"+document.getElementById("selectimage").value;
}

	
	</script>
  </head>
  
  <body>
   <%
   DB db=new DB();
   int id=Integer.parseInt(request.getParameter("id"));
   User user=db.getUserMessage(id);
    %>

  <div style="margin-top:60px;">
   <br><form action="/MessageBoardCss/servlet/updateUser" method="post" name="myform">
   <input type="hidden" value="<%=id %>" name="updateuserid">
   用户名：<input type="text" name="username" value="<%=user.getUsername() %>">
   <br><br>&nbsp; 
   密码：<input type="text" name="userpwd" value="<%=user.getUserpwd()%>" ><br><br>&nbsp; 性别： 男<input type="radio" checked="checked" name="usersex" value="男">
       女<input type="radio"  name="usersex" value="女"><br><br>
       
     <img alt="" src="image/<%=user.getUserphoto() %>" id="image1" width="100" height="100">  
     <br><br>选择头像：<select name="userphoto" id="selectimage" onchange="showlogo()">
<option value="1.gif">头像1</option>
<option value="2.gif">头像2</option>
<option value="3.gif">头像3</option>
<option value="4.gif">头像4</option>
<option value="5.gif">头像5</option>
<option value="6.gif">头像6</option>
<option value="7.gif">头像7</option>
<option value="8.gif">头像8</option>
<option value="9.gif">头像9</option>
<option value="10.gif">头像10</option>
</select>

<br><br><br>       
家庭住址：<select name="useradr" >
<option value="南京">南京</option>
<option value="青岛">青岛</option>
<option value="泰安">泰安</option>
<option value="济南">济南</option>
</select><br><br>个人爱好：篮球<input type="checkbox"  name="userhobby" value="篮球">
足球<input type="checkbox"  name="userhobby" value="足球">
乒乓球<input type="checkbox"  name="userhobby" value="乒乓球">
羽毛球<input type="checkbox"  name="userhobby" value="羽毛球"><br><br>
个人简介：<textarea cols="30" rows="6" name="userintro" value=""<%=user.getUserinfo() %>></textarea>
<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
<input type="submit" value="修改" name="submit"> &nbsp; &nbsp; &nbsp; &nbsp; 
<input type="reset" value="重置" name="button2"></form>

</div>	
  </body>
</html>
