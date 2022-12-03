package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Model.BEAN.SV;
import Model.BO.AccountBO;
import Model.BO.SVBO;
@WebServlet("/ViewListSV")
public class ViewListSV extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		HttpSession session = request.getSession();
		SVBO svBO=new SVBO();
		AccountBO accountBO=new AccountBO();
		ArrayList<SV> listSV=new ArrayList<SV>();
		RequestDispatcher rd=null;
		
		listSV=svBO.getSVByIdgv(accountBO.GetidByUsername(session.getAttribute("username").toString()));
		request.setAttribute("ListSV", listSV);
		for (int i=0;i<listSV.size();i++)
		{
			if(request.getParameter("edit"+i)!=null)
			{
				request.setAttribute("diem", listSV.get(i).getdiem());
				session.setAttribute("id",listSV.get(i).getid());
				rd=getServletContext().getRequestDispatcher("/WebContent/Changediem.jsp");
				break;
			}
			else
			{
				rd=getServletContext().getRequestDispatcher("/WebContent/ViewListSV.jsp");
			}
		}
		rd.forward(request, response);
	}
}