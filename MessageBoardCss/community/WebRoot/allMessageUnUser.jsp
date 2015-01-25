<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="db.DB" %>
<%@ page import="model.Message" %>
<%@ page import="model.ReplyMessage" %>
<%@ page import="model.User" %>
<%@ page import="page.Pager" %>
<%@ page import="java.util.ArrayList"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <base href="<%=basePath%>">
    
    <title>My JSP 'allMessage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/style.css" type="text/css" media="screen" />
    <style type="text/css">
     .im{text-align:left; font-size:13px; border:#FFCC99 1px solid; margin-top:-15px;}
    </style>
  </head>
  
  <body>
    <div id="body_wrapper">


		<!-- Start of Body Container -->

		<div id="body_container">
		<div id="body_container_b">
		<div id="body_container_c">
		
		<div style="text-align:left; padding-left:10px; padding-top:10px; font-weight:bold; color:#666666 ;">当前用户：${user.username }</div>
 	 <!-- Start of Page Content -->

			<div id="page_content"><br /><div class="tb_center">
				<br />
				</div>
				
<div class="im">				
<table width="100%" cellpadding="0" cellspacing="0" style="line-height:30px;">				  

  <%
ArrayList list=(ArrayList)request.getAttribute("messageList");
ArrayList listreply=null;
Iterator iter=list.iterator();
while(iter.hasNext())
{
	Message message=(Message)iter.next();
	DB db=new DB();
	String photo=db.getUserMessage(message.getUserId()).getUserphoto();
	String username=db.getUserMessage(message.getUserId()).getUsername();
	String useradr=db.getUserMessage(message.getUserId()).getUseradr();
 %>
  
  <tr>
    <td width="25%" style="border-bottom:#ADAF9A 1px dotted;border-right:#ADAF9A 1px dotted;">
	<div> <font style="color:#660000;font-size:9px;">**<%=username %>**</font>
</div>
	<div style="padding-left:25px;"> <img src="image/<%=photo%>" alt="" width="50" height="50" /></div>
	<div style="color:#003300;font-size:9px;" >来自:<%=useradr %></div>
	 </td>
    <td style="border-bottom:#ADAF9A 1px dotted;">
	<div style="padding-left:20px; color:#C2C2C2;">留言时间：<%=message.getDate()%></div>
	<div style="padding-left:20px; color:#FF3300"> 标题：<%=message.getTitle() %></div>
	<div style="padding-left:20px; color:#CCFFCC;"> 留言内容:<%=message.getContent() %></div>
	<div style="padding-left:40px;color:#CCCCCF;">
	<%
	listreply=db.getReplyMessage(message.getId());	
	if(listreply!=null)
	{
		Iterator iter2=listreply.iterator();
		while(iter2.hasNext())
		{
			ReplyMessage replymessage=(ReplyMessage)iter2.next();
		
		%>
		
		<%=replymessage.getReplyusername() %>回复说：<%=replymessage.getReplycontent() %>    [<%=replymessage.getReplydate() %>]<br/>
		
		<%
		
		}
		
	   }
	 %>
	</div>
	
	
	</td>

  </tr>
 
  <%} %>
  
</table>
</div>	
				
				
				<div class="link_readmore"><a href="http://sc.chinaz.com/" title="Read more"><span class="hidethis">Read more</span></a>
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
			<li><a href="findMessage.jsp">检索留言</a></li>
			<li><a href="userRegister.jsp">用户注册</a></li>
			<li><a href="userLogin.jsp">用户登录</a></li>
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
