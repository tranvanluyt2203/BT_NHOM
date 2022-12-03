package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.BEAN.GV;
import Model.BO.AccountBO;
import Model.BO.GVBO;
import Model.BO.SVBO;

@WebServlet("/ViewGV")
public class ViewGV extends HttpServlet
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
		GVBO gvBO = new GVBO();
		SVBO svBO=new SVBO();
		GV gv=new GV();
		gv=gvBO.SearchGV("id", svBO.getSV(accountBO.GetidByUsername(session.getAttribute("username").toString())).getid());
		request.setAttribute("gv", gv);
		destination="/WebContent/ViewGV.jsp";
		RequestDispatcher rd=getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	}
}