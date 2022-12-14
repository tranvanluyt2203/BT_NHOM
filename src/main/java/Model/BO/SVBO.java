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
	public void UpdateInfor(SV sv)
	{
		svDAO.UpdateInforSV(sv);
	}
	public void UpdateDiem(SV sv)
	{
		svDAO.UpdateDiemSV(sv);
	}
	public SV SearchSV(String factor,String nfactor)
	{
		return svDAO.SearchSV(factor, nfactor);
	}
	public void Add(SV sv)
	{
		svDAO.Add(sv);
	}
}
