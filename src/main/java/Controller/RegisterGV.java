package Controller;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.BEAN.GV;
import Model.BO.GVBO;

@WebServlet("/RegisterGV")
public class RegisterGV extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		String destination=null;
		GVBO gvBO=new GVBO();
		GV gv=new GV();
		gv.setid(request.getParameter("id"));
		gv.setname(request.getParameter("name"));
		gv.setage(Integer.parseInt(request.getParameter("age")));
		gv.setlesson(request.getParameter("lesson"));
		gvBO.Add(gv);
		destination = "/WebContent/Welcome.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
		
	}
}
