<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen" />
    <title>My JSP 'addMessage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

   <style type="text/css">
   .btn{width:50px;height:20px;background-color:transparent;border:#CCCC99 1px solid; color:#660000;}
   .txt{background-color:transparent;border:#CCCC99 1px solid;}
   table tr td{border:#999999 1px dotted;color:#660000;padding:5px;}
   table{border-collapse:collapse}
   </style>
  </head>
  
  <body>
 <div id="body_wrapper">


		<!-- Start of Body Container -->

		<div id="body_container">
		<div id="body_container_b">
		<div id="body_container_c">


			<!-- Start of Page Header -->

			<div id="page_header">

				<!-- Website Title -->

				<h1 style="color:#CCCC99">用户留言</h1>

			</div>

			<!-- End of Page Header -->


			<!-- Start of Page Content -->

			<div id="page_content"><br />
			<div class="tb_center">
 
  <%
  if(request.getSession().getAttribute("user")==null)
  {
   response.sendRedirect("/MessageBoard/Login.jsp");
  }
   %>
    <form action="servlet/addMessage" method="post">
    <p style="margin-top:30px;"></p>
    <table border="1" width="70%">
   
    <tr>
    <td>留言标题</td>
    <td><input type="text" name="title" class="txt"/></td>
    </tr>
    <tr>
    <td>留言内容</td>
    <td><textarea name="content" rows="5" cols="25" class="txt" ></textarea></td>
    </tr>
     <tr>
    <td></td>
    <td style="padding-left:30px;"><input type="submit" value="提交" class="btn">         <input type="reset" value="重置" class="btn"></td>
    </tr>
    </table>
    <p style="margin-top:30px;"></p>
    
    </form>
  <br />
				</div><br /><div class="link_readmore">
				</div>


			</div>

			<!-- End of Page Content -->

		</div>
		</div>
		</div>

		<!-- End of Body Container -->



		<!-- Start of Navigation Menu -->

		<div id="navmenu">
		<div id="navmenu_b">
		<div id="navmenu_c">

			<h3><span class="hidethis">Site Menu:</span></h3>

			<ul>
			<li class="list_first"><a href="servlet/goodMessage">首页</a></li>
			<li><a href="servlet/mainServlet">全部留言</a></li>
			<li><a href="servlet/goodMessage">经典说说</a></li>
			<li><a href="addMessage.jsp">我来侃侃</a></li>
			<li><a href="queryMessage.jsp">检索留言</a></li>
			<li><a href="userRegister.jsp">用户注册</a></li>
			<li><a href="Login.jsp">用户登录</a></li>
			<li><a href="contactManager.jsp">联系管理员</a></li>
			<li><a href="exitSuccess.jsp">退出</a></li>
			</ul>


		</div>
		</div>
		</div>

		<!-- End of Navigation Menu -->


		<div class="clearthis">&nbsp;</div>


		<!-- Start of Page Footer -->

		<div id="page_footer">版权所属J2EE开发组<br /> 
		<a href="http://sc.chinaz.com/"></a>
		</div>

		<!-- End of Page Footer -->
	</div>
  </body>
</html>
