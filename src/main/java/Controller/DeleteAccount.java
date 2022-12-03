package Controller;

import java.io.IOException;
import java.net.http.HttpResponse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Model.BO.AccountBO;
import Model.BO.SVBO;

@WebServlet("/DeleteAccount")
public class DeleteAccount extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		SVBO svBO=new SVBO();
		AccountBO accountBO=new AccountBO();
		HttpSession session=request.getSession();
		svBO.DelSV(accountBO.GetidByUsername(session.getAttribute("username").toString()));
		accountBO.DelAccount(accountBO.GetidByUsername(session.getAttribute("username").toString()));
		request.setAttribute("mess","Đã xóa tài khoản");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WebContent/logout.jsp");
		rd.forward(request, response);
	}
	
}
