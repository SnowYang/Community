package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

import db.DB;

public class mainServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		String username=request.getParameter("username");
		String userpwd=request.getParameter("userpwd");
		
		
		DB db=new DB();
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		if(user==null)
		{
			user=db.checkUser(username, userpwd);
			session.setAttribute("user", user);
			
		
		}
		
		
		if(user!=null)
		{
			
			ArrayList list=db.findMessageInfo();
			request.setAttribute("messageList", list);
			request.getRequestDispatcher("/allMessage.jsp").forward(request, response);
			
		}
		else
		{
			response.sendRedirect("/MessageBoardCss/Login.jsp");
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request,response);
		

}
}
