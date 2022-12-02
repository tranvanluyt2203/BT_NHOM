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

import Model.BEAN.SV;
import Model.BO.SVBO;

@WebServlet("/RegisterSV")
public class RegisterSV extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		String destination=null;
		SVBO svBO=new SVBO();
		SV sv=new SV();
		sv.setid(request.getParameter("id"));
		sv.setname(request.getParameter("name"));
		sv.setage(Integer.parseInt(request.getParameter("age")));
		sv.setidgv(request.getParameter("GV"));
		svBO.Add(sv);
		destination = "/WebContent/Welcome.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
		
	}
}
