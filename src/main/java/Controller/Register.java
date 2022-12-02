package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.BEAN.Account;
import Model.BEAN.GV;
import Model.BO.AccountBO;
import Model.BO.GVBO;

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
		{   
			Account account=new Account();
			if (userName!=null||password!=null) 
			{
				session.setAttribute("username", userName);
				session.setAttribute("password", password);
				if (type.equals("admin"))
				{
					session.setAttribute("type","listchoiceGV.html");
					account.settype(type);
					if (RegisterBO.Num_next_GV()<10) account.setid("AD0"+RegisterBO.Num_next_GV());
					else 
					{
						account.setid("AD"+RegisterBO.Num_next_GV());
					}
				}
				else if (type.equals("user"))
				{
					session.setAttribute("type","listchoiceSV.html");
					account.settype(type);
					if (RegisterBO.Num_next_SV()<10) account.setid("U0"+RegisterBO.Num_next_SV());
					else 
					{
						account.setid("U"+RegisterBO.Num_next_SV());
					}
				}
				account.setusername(userName);
				account.setpassword(password);
				RegisterBO.Add(account);
				request.setAttribute("id", account.getid());
				if (type.equals("admin"))
				{
					destination = "/WebContent/register_gv.jsp";
				}
				else
				{
					GVBO gvBO=new GVBO();
					ArrayList<GV> listgv=gvBO.getGVList();
					for (int i=0;i<listgv.size();i++)
					{
						request.setAttribute(String.valueOf(i), listgv.get(i).getname());
						request.setAttribute("idgv"+String.valueOf(i), listgv.get(i).getid());
					}
						
					request.setAttribute("size",listgv.size());
					destination = "/WebContent/register_sv.jsp";
				}
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);
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
