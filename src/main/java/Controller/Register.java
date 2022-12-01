package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.BEAN.Account;
import Model.BO.AccountBO;

@WebServlet("/Register")
public class Register extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		HttpSession session = request.getSession();
		String userName = request.getParameter("usernamer");
		String password = request.getParameter("passwordr");
		String destination=null;
		String type = request.getParameter("type");
		AccountBO RegisterBO = new AccountBO();
		if(RegisterBO.isAccountExist(userName, password))
		{
			System.out.print("Đã tồn tại");
		}
		else
		{   Account account=new Account();
			if (userName!=null||password!=null) 
			{
				account.setusername(userName);
				account.setpassword(password);
				RegisterBO.Add(account, type);
			}
			else
			{
				destination = "/WebContent/register.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);
			}
			
		}	
	}
}
