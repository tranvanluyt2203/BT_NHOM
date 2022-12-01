package Model.BO;

import java.util.ArrayList;

import Model.BEAN.SV;
import Model.DAO.SVDAO;

public class SVBO 
{
	SVDAO svDAO=new SVDAO();
	public ArrayList<SV> getSVByIdgv(String idgv)
	{
		return svDAO.getSVByIdgv(idgv);
	}
	public SV getSV(String id)
	{
		return svDAO.getSV(id);
	}
	public void DelSV(String id)
	{
		svDAO.DelSV(id);
	}
	public void Update(SV sv)
	{
		svDAO.UpdateSV(sv);
	}
	public SV SearchSV(String factor,String nfactor)
	{
		return svDAO.SearchSV(factor, nfactor);
	}

}
