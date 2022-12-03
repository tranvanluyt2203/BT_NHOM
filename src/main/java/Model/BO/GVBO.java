package Model.BO;

import java.util.ArrayList;

import Model.BEAN.GV;
import Model.DAO.GVDAO;

public class GVBO 
{
	GVDAO gvDAO=new GVDAO();
	public ArrayList<GV> getGVList()
	{
		return gvDAO.getGVList();
	}
	public GV getGV(String idgv)
	{
		return gvDAO.getGV(idgv);
	}
	public void Add(GV gv)
	{
		gvDAO.Add(gv);
	}
	public GV SearchGV(String factor,String nFactor)
	{
		return gvDAO.SearchGV(factor, nFactor);
	}
	public void UpdateGV(GV gv)
	{
		gvDAO.UpdateGV(gv);
	}
}
