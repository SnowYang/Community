package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DB;

import model.User;

public class RegisterServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
	
	
		String username=request.getParameter("username");
		String userpwd=request.getParameter("userpwd");
		String usersex=request.getParameter("usersex");
		String useradr=request.getParameter("useradr");
		String userintro=request.getParameter("userintro");
		String []hobby=request.getParameterValues("userhobby");
		String userphoto=request.getParameter("userphoto");
		String userhobby = null;
		for(int i=0;i<hobby.length;i++){
			userhobby=userhobby+hobby[i];
		}
		
		User user=new User();
		user.setUseradr(useradr);
		user.setUserhobby(userhobby);
		user.setUserinfo(userintro);
		user.setUsername(username);
		user.setUserpwd(userpwd);
		user.setUsersex(usersex);
		user.setUserphoto(userphoto);
		user.setUserstatus("0");
		
	
		
		
		DB db=new DB();
		if(db.insertUser(user))
		{
			response.sendRedirect("/MessageBoardCss/registerSuccess.jsp");
			
		}
		else
		{
			out.println("×¢²áÊ§°Ü£¡");
		}
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
			doGet(request,response);
		
	}

}
