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
@WebServlet("/Changediem")
public class Changediem extends HttpServlet
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
		RequestDispatcher rd=null;
		if(request.getParameter("change")!=null)
		{
			SV sv=new SV();
			sv.setid(session.getAttribute("id").toString());
			sv.setdiem(Float.parseFloat(request.getParameter("diem").toString()));
			svBO.UpdateDiem(sv);
			rd=getServletContext().getRequestDispatcher("/ViewListSV");
		}
		rd.forward(request, response);
	}
}