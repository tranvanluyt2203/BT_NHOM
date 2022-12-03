package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Model.BEAN.GV;
import Model.BEAN.SV;
import Model.BO.AccountBO;
import Model.BO.GVBO;
import Model.BO.SVBO;
@WebServlet("/EditDetails")
public class UpdateInforActor extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		HttpSession session = request.getSession();
		AccountBO accountBO=new AccountBO();
		String destination=null;
		GVBO gvBO=new GVBO();
		SVBO svBO=new SVBO();
		String type=accountBO.GettypeByUsername(session.getAttribute("username").toString());
		System.out.println(type);
		if (type.equals("admin"))
		{
			RequestDispatcher rd=null;
			request.setAttribute("gv",gvBO.SearchGV("id", accountBO.GetidByUsername(session.getAttribute("username").toString())));
			
			if (request.getParameter("edit")!=null)
			{
				GV gv=new GV();
				gv.setid(request.getParameter("id"));
				gv.setname(request.getParameter("name"));
				gv.setage(Integer.parseInt(request.getParameter("age")));
				gv.setlesson(request.getParameter("lesson"));
				gvBO.UpdateGV(gv);
				System.out.println("\n"+request.getParameter("edit")+gv.getage());
				destination="/WebContent/Welcome.jsp";
				rd= getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);
			}
			else 
			{
				destination="/WebContent/EditGV.jsp";
				rd= getServletContext().getRequestDispatcher(destination);
			}
			rd.forward(request, response);
		}
		else if (type.equals("user"))
		{
			RequestDispatcher rd=null;
			request.setAttribute("sv",svBO.SearchSV("id", accountBO.GetidByUsername(session.getAttribute("username").toString())));
			if (request.getParameter("edit")!=null)
			{
				SV sv=new SV();
				sv.setid(request.getParameter("id"));
				sv.setname(request.getParameter("name"));
				sv.setage(Integer.parseInt(request.getParameter("age").toString()));
				sv.setidgv(request.getParameter("idgv"));
				sv.setdiem(Float.parseFloat(request.getParameter("diem")));
				svBO.UpdateInfor(sv);
				destination="/WebContent/Welcome.jsp";
				rd= getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);
			}
		}
		
	}
}
