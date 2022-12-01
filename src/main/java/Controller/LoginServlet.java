package Controller;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import Model.BO.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		HttpSession session = request.getSession();
		String destination = null; 
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		AccountBO LoginBO = new AccountBO();
		
		if(LoginBO.isAccountExist(userName, password))
		{
			session.setAttribute("username",userName);
			if (LoginBO.getTypeAccount(userName,password).equals("admin"))
			{
				session.setAttribute("type","listchoiceGV.html");
			}
			else if (LoginBO.getTypeAccount(userName,password).equals("user"))
			{
				session.setAttribute("type","listchoiceSV.html");
			}
			destination = "/WebContent/Welcome.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(request, response);
		}
		else
		{    
			destination = "/WebContent/login.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(request, response);
		}	
	}
}

